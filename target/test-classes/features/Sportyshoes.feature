Feature: Rest API testing on http://localhost:9010/

  Scenario: API ables to Get all products,Add,Update,Delete products and Get all registered users
    Given listof users are registered get-users method
    Given list of products are available  get-shoes method
    Then add a product using post method
    Then update the product details using put method
    Then delete the product
