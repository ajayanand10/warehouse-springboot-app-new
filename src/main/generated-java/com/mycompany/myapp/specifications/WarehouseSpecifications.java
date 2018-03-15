package com.mycompany.myapp.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.mycompany.myapp.domain.Warehouse;
import com.mycompany.myapp.domain.WarehouseSearch;
import com.mycompany.myapp.domain.Warehouse_;

public final class WarehouseSpecifications {
	 
    private WarehouseSpecifications() {}
 
    public static Specification<Warehouse> searchSpecifications(WarehouseSearch warehouseSearch) {
        return (root, query, cb) -> {
            String containsLikePattern1 = getContainsLikePattern(warehouseSearch.getLocation());
            String containsLikePattern2 = getContainsLikePattern(warehouseSearch.getType());
            Integer minStorageSize = (warehouseSearch.getMinStorageSize() == null) ? 0 : warehouseSearch.getMinStorageSize();
            Integer maxStorageSize = (warehouseSearch.getMaxStorageSize() == null) ? 999999999 : warehouseSearch.getMaxStorageSize();
            
            return cb.and(
                    cb.like(cb.lower(root.<String>get(Warehouse_.address)), containsLikePattern1),
                    cb.like(cb.lower(root.<String>get(Warehouse_.type)), containsLikePattern2),
                    cb.ge(root.<Integer>get(Warehouse_.storageSize),minStorageSize),
                    cb.lt(root.<Integer>get(Warehouse_.storageSize),maxStorageSize)
            );
        };
    }
    
    private static String getContainsLikePattern(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return "%";
        }
        else {
            return "%" + searchTerm.toLowerCase() + "%";
        }
    }
}