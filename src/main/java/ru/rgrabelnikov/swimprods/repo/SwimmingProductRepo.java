package ru.rgrabelnikov.swimprods.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rgrabelnikov.swimprods.service.Products.SwimmingProduct;

public interface SwimmingProductRepo extends JpaRepository<SwimmingProduct, Long> {
}
