package one.digitalinnovation.beerstock.repository;

import one.digitalinnovation.beerstock.dto.BeerDTO;
import one.digitalinnovation.beerstock.dto.BrandDTO;
import one.digitalinnovation.beerstock.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BeerRepository extends JpaRepository<Beer, Long> {

    Optional<Beer> findByName(String name);

    @Query(value = "SELECT * FROM BEER WHERE BRAND = ?1", nativeQuery = true)
    List<Beer> findByBrand(String brand);

    @Query(value = "SELECT * FROM BEER WHERE QUANTITY <= ?1", nativeQuery = true)
    List<Beer> findByQuantity(Integer quantity);

    @Modifying
    @Query(value = "UPDATE BEER SET BRAND = ?2 WHERE BRAND = ?1", nativeQuery = true)
    void renameBrand(String oldName, String newName);
}
