package tn.studio.myfood.product.domain

import tn.studio.myfood.product.domain.entity.ProductEntity

interface ProductRepository {

    suspend fun addProductToAisle(product: ProductEntity): Boolean
    suspend fun fetchAllProducts(): List<ProductEntity>
    suspend fun fetchProductById(id: String): ProductEntity

}