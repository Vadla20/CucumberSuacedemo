Feature: remove item in cart

Scenario: Login and remove item to cart
Given User is on the SauceDemo login page
When User logs in with username "standard_user" and password "secret_sauce"
And User adds the first item to the cart
Then The item should be present in the cart
And The item is removen from Cart
