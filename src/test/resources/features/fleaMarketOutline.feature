@fleaOutline
  Business Need: do the outline of things



    #  Landing Page
#  Verify Page Title
#  Verify Product Categories (Both)
#  Verify Cart Icon
#  Verify Image Slider
#  Verify Filters
#  Verify Contact Button
#  Click Through EACH of the Categories, Products and Filters


    @fleaOutline1
    Scenario Outline: Landing Page
      Given I visit FLEA Market in the "QA" Environment
      Then I verify title is "e-commerce – Automation Practice Website" for the page
      When I wait and click on a product "<product>" on the Landing Page

      Examples:
        |product|
        |AirPods Pro|
        |Apple Watch Series 6|
        |iMac                |
        |IPhone 12           |
        |IPhone XR           |
        |Macbook Air         |

    @fleaOutline2
    Scenario Outline: Product Page
      Given I visit FLEA Market in the "QA" Environment
      When I wait and click on a product "<product>" on the Landing Page


      Examples:
        |product| title|
        |AirPods Pro| AirPods Pro - e-commerce|
        |Apple Watch Series 6|Apple Watch Series 6|
        |iMac                |iMac - e-commerce           |
        |IPhone 12           |IPhone 12 - e-commerce           |
        |IPhone XR           |IPhone XR - e-commerce         |
        |Macbook Air         |Macbook Air - e-commerce         |



  #    Product Page
#    Scroll Down and verify Product Description Page
#    Find the Product By Name and Click it
#    Increase the Counter and Add to Cart
#    Verify Product has been added
#    Click Each of the Slide Out tabs as well
#    Click Through EACH Product
#    Verify All of their product Descriptions



      #    "Add to Cart" functionality
#    Add to Cart from Landing Page
#    Hover Over Cart Icon and Verify
#    Click View Cart Verify Item is in Cart
#    Change the Quantity of the Item and Click Update
#    Verify Items are updated
#    Click the Remove Icon and Verify Item is Updated
#    Add EACH Item from product Page
#    Then Remove Item from Cart Hover Menu

#  @flea13
#  Scenario Outline: Add to Cart Flow
#    Given I visit FLEA Market in the "QA" Environment
#
#    Examples:
#
##    Checkout Flow/Confirmation
##    Add an Item from Landing Page
##    Go to Cart page and verify that you are there
##    Click Proceed to Checkout
##    Fill out the Checkout page and Click Place Order
##    Verify the Confirmation Page and all of the information there
##    Do this for EACH Item
#
#  @flea14
#  Scenario Outline: Checkout/Confirmation
#    Given I visit FLEA Market in the "QA" Environment
#
#    Examples: