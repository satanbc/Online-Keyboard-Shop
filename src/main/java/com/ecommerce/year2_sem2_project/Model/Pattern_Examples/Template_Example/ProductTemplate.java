package com.ecommerce.year2_sem2_project.Model.Pattern_Examples.Template_Example;

/// Клас шаблону
public abstract class ProductTemplate {

    /// Шаблонний метод
    public final void processProduct() {
        retrieveProductData();
        validateProductData();
        saveProductData();
    }

    /// Абстрактні методи, які будуть реалізовані підкласами
    protected abstract void retrieveProductData();
    protected abstract void validateProductData();
    protected abstract void saveProductData();
}