package ru.maksirep.technique_registry.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.maksirep.technique_registry.core.entity.Model;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

    @Transactional
    @Query(value = "INSERT INTO model (name, serial_number, color, size, price, is_on_stock, product_id)\n" +
            "VALUES (:name, :serial_number, :color, :size, :price, :is_on_stock, :product_id)" +
            "RETURNING id", nativeQuery = true)
    int createModel(@Param("name") String name,
                    @Param("serial_number") String serialNumber,
                    @Param("color") String color,
                    @Param("size") String size,
                    @Param("price") int price,
                    @Param("is_on_stock") boolean isOnStock,
                    @Param("product_id") int productId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO computer_model (id, category, processor_type)\n" +
            "VALUES (:id, :category, :processor_type)", nativeQuery = true)
    void createComputer(@Param("id") int id,
                        @Param("category") String category,
                        @Param("processor_type") String processorType);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO refrigerator_model (id, number_of_doors, compressor_type)\n" +
            "VALUES (:id, :number_of_doors, :compressor_type)", nativeQuery = true)
    void createRefrigerator(@Param("id") int id,
                            @Param("number_of_doors") int numberOfDoors,
                            @Param("compressor_type") String compressorType);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO smartphone_model (id, memory, number_of_cameras)\n" +
            "VALUES (:id, :memory, :number_of_cameras)", nativeQuery = true)
    void createSmartphone(@Param("id") int id,
                          @Param("memory") int memory,
                          @Param("number_of_cameras") int numberOfCameras);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO television_model (id, tv_category, technology)\n" +
            "VALUES (:id, :tv_category, :technology)", nativeQuery = true)
    void createTelevision(@Param("id") int id,
                          @Param("tv_category") String tvCategory,
                          @Param("technology") String technology);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO vacuum_cleaner_model (id, dust_bag_volume, number_of_modes)\n" +
            "VALUES (:id, :dust_bag_volume, :number_of_modes)", nativeQuery = true)
    void createVacuumCleaner(@Param("id") int id,
                             @Param("dust_bag_volume") int dustBagVolume,
                             @Param("number_of_modes") int numberOfModes);

    @Query(value = "SELECT model.id             AS id,\n" +
            "       model.name           AS name,\n" +
            "       model.serial_number  AS serial_number,\n" +
            "       model.color          AS color,\n" +
            "       model.size           AS size,\n" +
            "       model.price          AS price,\n" +
            "       model.is_on_stock    AS is_on_stock,\n" +
            "       model.product_id     AS product_id,\n" +
            "       cm.category          AS category,\n" +
            "       cm.processor_type    AS processor_type,\n" +
            "       rm.number_of_doors   AS number_of_doors,\n" +
            "       rm.compressor_type   AS compressor_type,\n" +
            "       sm.memory            AS memory,\n" +
            "       sm.number_of_cameras AS number_of_cameras,\n" +
            "       tm.tv_category       AS tv_category,\n" +
            "       tm.technology        AS technology,\n" +
            "       vcm.dust_bag_volume  AS dust_bag_volume,\n" +
            "       vcm.number_of_modes  AS number_of_modes\n" +
            "FROM model\n" +
            "         LEFT JOIN computer_model cm ON model.id = cm.id\n" +
            "         LEFT JOIN refrigerator_model rm ON model.id = rm.id\n" +
            "         LEFT JOIN smartphone_model sm ON model.id = sm.id\n" +
            "         LEFT JOIN television_model tm ON model.id = tm.id\n" +
            "         LEFT JOIN vacuum_cleaner_model vcm ON model.id = vcm.id\n" +
            "ORDER BY CASE\n" +
            "             WHEN :sort_rule = 'ASC' AND :sort_field = 'NAME' THEN LOWER(model.name)\n" +
            "             END ASC,\n" +
            "         CASE\n" +
            "             WHEN :sort_rule = 'DESC' AND :sort_field = 'NAME' THEN LOWER(model.name)\n" +
            "             END DESC,\n" +
            "         CASE\n" +
            "             WHEN :sort_rule = 'ASC' AND :sort_field = 'PRICE' THEN model.price\n" +
            "             END ASC,\n" +
            "         CASE\n" +
            "             WHEN :sort_rule = 'DESC' AND :sort_field = 'PRICE' THEN model.price\n" +
            "             END DESC", nativeQuery = true)
    List<Tuple> sortModel(@Param("sort_rule") String sortRule,
                          @Param("sort_field") String sortField);

    @Query(value = "SELECT EXISTS(SELECT TRUE FROM model WHERE serial_number = :serial_number)", nativeQuery = true)
    boolean isSerialNumberNotUnique(@Param("serial_number") String serialNumber);
}
