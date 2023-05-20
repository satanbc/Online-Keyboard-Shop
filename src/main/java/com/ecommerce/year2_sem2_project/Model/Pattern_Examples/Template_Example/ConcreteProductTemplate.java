package com.ecommerce.year2_sem2_project.Model.Pattern_Examples.Template_Example;

/// Конкретний підклас, що реалізує методи шаблону
public class ConcreteProductTemplate extends ProductTemplate {

    /// Збереження підтверджених даних продукту в базі даних
    @Override
    protected void retrieveProductData() {
        /// Отримання даних про продукт із джерела даних
    }

    /// Збереження підтверджених даних продукту в базі даних
    @Override
    protected void validateProductData() {
        /// Перевірка отриманих даних продукту
    }

    /// Збереження підтверджених даних продукту в базі даних
    @Override
    protected void saveProductData() {

    }
}
