package ru.maksirep.technique_registry.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.maksirep.technique_registry.api.dto.enums.ProductTypeDto;
import ru.maksirep.technique_registry.core.entity.Product;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Transactional
    @Query(value =
            "INSERT INTO product (name, country, manufacturer, is_online, is_installment)\n" +
                    "VALUES (:name, :country, :manufacturer, :is_online, :is_installment)" +
                    "RETURNING id", nativeQuery = true)
    int createProduct(@Param("name") String name,
                      @Param("country") String country,
                      @Param("manufacturer") String manufacturer,
                      @Param("is_online") boolean isOnline,
                      @Param("is_installment") boolean isInstallment);

    @Query(value = "SELECT EXISTS(SELECT TRUE FROM product WHERE id = :id)", nativeQuery = true)
    boolean isProductExistById(@Param("id") int id);

    @Query(value = "SELECT m.id                   AS id,\n" +
            "       product.name           AS name,\n" +
            "       product.country        AS country,\n" +
            "       product.manufacturer   AS manufacturer,\n" +
            "       product.is_online      AS is_online,\n" +
            "       product.is_installment AS is_installment,\n" +
            "       m.name                 AS model_name,\n" +
            "       m.serial_number        AS serial_number,\n" +
            "       m.color                AS color,\n" +
            "       m.size                 AS size,\n" +
            "       m.price                AS price,\n" +
            "       m.is_on_stock          AS is_on_stock,\n" +
            "       cm.category            AS category,\n" +
            "       cm.processor_type      AS processor_type,\n" +
            "       rm.number_of_doors     AS number_of_doors,\n" +
            "       rm.compressor_type     AS compressor_type,\n" +
            "       sm.memory              AS memory,\n" +
            "       sm.number_of_cameras   AS number_of_cameras,\n" +
            "       tm.tv_category         AS tv_category,\n" +
            "       tm.technology          AS technology,\n" +
            "       vcm.dust_bag_volume    AS dust_bag_volume,\n" +
            "       vcm.number_of_modes    AS number_of_modes\n" +
            "FROM product\n" +
            "         JOIN model m ON product.id = m.product_id\n" +
            "         LEFT JOIN computer_model cm ON m.id = cm.id AND (:productTypeDto LIKE 'COMPUTER' OR :productTypeDto IS NULL)\n" +
            "         LEFT JOIN refrigerator_model rm\n" +
            "                   ON m.id = rm.id AND (:productTypeDto LIKE 'REFRIGERATOR' OR :productTypeDto IS NULL)\n" +
            "         LEFT JOIN smartphone_model sm\n" +
            "                   ON m.id = sm.id AND (:productTypeDto LIKE 'SMARTPHONE' OR :productTypeDto IS NULL)\n" +
            "         LEFT JOIN television_model tm\n" +
            "                   ON m.id = tm.id AND (:productTypeDto LIKE 'TELEVISION' OR :productTypeDto IS NULL)\n" +
            "         LEFT JOIN vacuum_cleaner_model vcm\n" +
            "                   ON m.id = vcm.id AND (:productTypeDto LIKE 'VACUUM_CLEANER' OR :productTypeDto IS NULL)\n" +
            "WHERE (:name IS NULL OR LOWER(product.name) LIKE '%' || LOWER(:name) || '%')\n" +
            "  AND (:country IS NULL OR LOWER(product.country) LIKE '%' || LOWER(:country) || '%')\n" +
            "  AND (:manufacturer IS NULL OR LOWER(product.manufacturer) LIKE '%' || LOWER(:manufacturer) || '%')\n" +
            "  AND (:is_online IS NULL OR product.is_online = :is_online)\n" +
            "  AND (:is_installment IS NULL OR product.is_installment = :is_installment)\n" +
            "  AND (:color IS NULL OR LOWER(m.color) LIKE '%' || LOWER(:color) || '%')\n" +
            "  AND (:price_from IS NULL OR m.price >= :price_from)\n" +
            "  AND (:price_to IS NULL OR m.price <= :price_to)\n" +
            "  AND (:model_name IS NULL OR LOWER(m.name) LIKE '%' || LOWER(:model_name) || '%')\n" +
            "  AND (:serial_number IS NULL OR LOWER(m.serial_number) LIKE '%' || LOWER(:serial_number) || '%')\n" +
            "  AND (:size IS NULL OR LOWER(m.size) LIKE '%' || LOWER(:size) || '%')\n" +
            "  AND (:is_on_stock IS NULL OR m.is_on_stock = :is_on_stock)\n" +
            "  AND (\n" +
            "        (:productTypeDto IS NULL)\n" +
            "        OR (\n" +
            "                (:productTypeDto = 'COMPUTER' AND cm.id IS NOT NULL AND\n" +
            "                 (:category IS NULL OR LOWER(cm.category) LIKE '%' || LOWER(:category) || '%') AND\n" +
            "                 (:processor_type IS NULL OR LOWER(cm.processor_type) LIKE '%' || LOWER(:processor_type) || '%')) OR\n" +
            "                (:productTypeDto = 'REFRIGERATOR' AND rm.id IS NOT NULL AND\n" +
            "                 (:number_of_doors IS NULL OR rm.number_of_doors = :number_of_doors) AND\n" +
            "                 (:compressor_type IS NULL OR LOWER(rm.compressor_type) LIKE '%' || LOWER(:compressor_type) || '%')) OR\n" +
            "                (:productTypeDto = 'SMARTPHONE' AND sm.id IS NOT NULL AND\n" +
            "                 (:memory IS NULL OR sm.memory = :memory) AND\n" +
            "                 (:number_of_cameras IS NULL OR sm.number_of_cameras = :number_of_cameras)) OR\n" +
            "                (:productTypeDto = 'TELEVISION' AND tm.id IS NOT NULL AND\n" +
            "                 (:tv_category IS NULL OR LOWER(tm.tv_category) LIKE '%' || LOWER(:tv_category) || '%') AND\n" +
            "                 (:technology IS NULL OR LOWER(tm.technology) LIKE '%' || LOWER(:technology) || '%')) OR\n" +
            "                (:productTypeDto = 'VACUUM_CLEANER' AND vcm.id IS NOT NULL AND\n" +
            "                 (:dust_bag_volume IS NULL OR vcm.dust_bag_volume = :dust_bag_volume) AND\n" +
            "                 (:number_of_modes IS NULL OR vcm.number_of_modes = :number_of_modes))\n" +
            "            )\n" +
            "    )", nativeQuery = true)
    List<Tuple> filterProducts (@Param("name") String name,
                                @Param("country") String country,
                                @Param("manufacturer") String manufacturer,
                                @Param("is_online") Boolean isOnline,
                                @Param("is_installment") Boolean isInstallment,
                                @Param("productTypeDto") String productTypeDto,
                                @Param("color") String color,
                                @Param("price_from") Integer priceFrom,
                                @Param("price_to") Integer priceTo,
                                @Param("model_name") String modelName,
                                @Param("serial_number") String serialNumber,
                                @Param("size") String size,
                                @Param("is_on_stock") Boolean isOnStock,
                                @Param("category") String category,
                                @Param("processor_type") String processorType,
                                @Param("number_of_doors") Integer numberOfDoors,
                                @Param("compressor_type") String compressorType,
                                @Param("memory") Integer memory,
                                @Param("number_of_cameras") Integer numberOfCameras,
                                @Param("tv_category") String tvCategory,
                                @Param("technology") String technology,
                                @Param("dust_bag_volume") Integer dustBagVolume,
                                @Param("number_of_modes") Integer numberOfModes);
}
