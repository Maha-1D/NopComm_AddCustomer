Feature: Customer functionality

Scenario: Add new customer

Given User launch chrome browser
When user open app URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enter email as "admin@yourstore.com" and password as "admin"
And click on Login
Then User can view Dashboard
When User click on customers Menu
And click on customers Menu Item
And click on Add new button
Then User can view Add new customer page
When User enter customer info
And click on Save button
Then User can view confirmation message "new customer has been added successfully."
And close browser