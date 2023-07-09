package com.keremturak.service;

import com.keremturak.dto.request.ProductSaveRequestDto;
import com.keremturak.exceptions.ErrorType;
import com.keremturak.exceptions.YemekSepetiException;
import com.keremturak.mapper.IProductMapper;
import com.keremturak.repository.IProductRepository;
import com.keremturak.repository.entity.Product;
import com.keremturak.utility.ServiceManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends ServiceManager<Product, Long> {
    private final IProductRepository productRepository;
    private final RestaurantService restaurantService;

    public ProductService( IProductRepository productRepository,@Lazy RestaurantService restaurantService) {
        super(productRepository);
        this.productRepository = productRepository;
        this.restaurantService = restaurantService;
    }

    public Product save(ProductSaveRequestDto dto) {
        Product product = IProductMapper.INSTANCE.productSaveDto(dto);
        if (restaurantService.findById(dto.getRestaurantid()).isPresent()){
            return save(product);
        }throw new YemekSepetiException(ErrorType.BOYLE_BIR_RESTAURANT_YOK);

    }
    public List<Product> findAllProductByRestorant(Long id) {
        return productRepository.findAllByRestaurantid(id);
    }


    public List<Product> findAllByRestaurantId(Long restaurantId) {
        return productRepository.findAllByRestaurantid(restaurantId);
    }
}
