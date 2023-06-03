@test
Feature: Product Store Feature

  Background: Background Steps
   #Step1
    When I see "HomePage" page
    Then I go to url:"https://www.demoblaze.com/"
    Then I wait "product store title" element
    Then I sleep for 5 seconds
    Then I wait "navbar home button;navbar contact button;navbar about us button;navbar cart button;navbar log in button;navbar sign up button;categories tab;monitors tab;phones tab;laptops tab" elements


  @Dynamic
  Scenario:Product Store Test Case With Dynamic User
  #sign up with random user
    Then I wait until element to be clickable and click to "navbar sign up button" element
    When I see "SignUpModalPage" page
    Given I create a username that is start with "test" and end with number 1000000 between 9999999 then save username to globalvariables as a "username" and then sign up
    #Step3
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "navbar log in button" element
    Then I see "LoginModalPage" page
    Then I wait "login modal title;username label;password label;close icon;close button;login button" elements
    Then I send key to "username input" element text:"${username}"
    Then I send key to "password input" element text:"123"
    Then I wait until element to be clickable and click to "login button" element
    Then I sleep for 5 seconds
    When I see "HomePage" page
    Then I check "username welcome text" element text is equal "Welcome ${username}"
    #Step4
    Then I scroll down until find "htc one m9 text" element
    Then I wait until element to be clickable and click to "htc one m9 text" element
    Then I check "product name text" element text is equal "HTC One M9"
    Then I check "product description" element text is equal "The HTC One M9 is powered by 1.5GHz octa-core Qualcomm Snapdragon 810 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage that can be expanded up to 128GB via a microSD card. "
    #check product price
    Then I check element text is equal "$700 *includes tax" with query selector "document.querySelector('#tbodyid > h3').textContent"
    Then I wait until element to be clickable and click to "add to cart button" element
    Then I sleep for 5 seconds
    Then I check alert text is equals "Product added."
    Then I accept alert
    Then I sleep for 5 seconds
    Then I wait until element to be clickable and click to "navbar cart button" element
    Then I see "CartPage" page
    Then I wait "cart page title;products table;products table pic header;products table title header;products table price header;products table delete header;place order button;product delete button" elements
    Then I wait until element to be clickable and click to "place order button" element
    Then I see "OrderModalPage" page
    Then I wait "htc one m9 order modal price;name input;name label;city input;city label;credit card input;credit card label;month input;month label;year input;year label;order modal close button;order modal purchase button" elements
   # Then I send key to "Guray Turan" element text:"name input"
    Then I send key to "Guray Turan" element text:"name" with jsexecutor
    Then I send key to "Turkey" element text:"country" with jsexecutor
    Then I send key to "Balikesir" element text:"city" with jsexecutor
    Then I send key to "12344567878902345" element text:"card" with jsexecutor
    Then I send key to "03" element text:"month" with jsexecutor
    Then I send key to "2024" element text:"year" with jsexecutor
    Then I wait until element to be clickable and click to "order modal purchase button" element
    Then I wait "success icon;thanks for purchase text;ok button" elements
    Then I wait until element to be clickable and click to "ok button" element
    Then  I see "HomePage" page
    Then I wait "categories tab;monitors tab;phones tab;laptops tab" elements


  @Static
  Scenario:Product Store Test Case With Static User
    #Step3
    When I see "HomePage" page
    Then I wait until element to be clickable and click to "navbar log in button" element
    Then I see "LoginModalPage" page
    Then I wait "login modal title;username label;password label;close icon;close button;login button" elements
    Then I send key to "username input" element text:"gry"
    Then I send key to "password input" element text:"123"
    Then I wait until element to be clickable and click to "login button" element
    Then I sleep for 5 seconds
    When I see "HomePage" page
    Then I check "username welcome text" element text is equal "Welcome ${username}"
    #Step4
    Then I delete items on cart
    Then I scroll down until find "htc one m9 text" element
    Then I wait until element to be clickable and click to "htc one m9 text" element
    Then I check "product name text" element text is equal "HTC One M9"
    Then I check "product description" element text is equal "The HTC One M9 is powered by 1.5GHz octa-core Qualcomm Snapdragon 810 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage that can be expanded up to 128GB via a microSD card. "
    #check product price
    Then I check element text is equal "$700 *includes tax" with query selector "document.querySelector('#tbodyid > h3').textContent"
    Then I wait until element to be clickable and click to "add to cart button" element
    Then I sleep for 5 seconds
    Then I check alert text is equals "Product added."
    Then I accept alert
    Then I sleep for 5 seconds
    Then I wait until element to be clickable and click to "navbar cart button" element
    Then I see "CartPage" page
    Then I wait "cart page title;products table;products table pic header;products table title header;products table price header;products table delete header;place order button;product delete button" elements
    Then I wait until element to be clickable and click to "place order button" element
    Then I see "OrderModalPage" page
    Then I wait "htc one m9 order modal price;name input;name label;city input;city label;credit card input;credit card label;month input;month label;year input;year label;order modal close button;order modal purchase button" elements
   # Then I send key to "Guray Turan" element text:"name input"
    Then I send key to "Guray Turan" element text:"name" with jsexecutor
    Then I send key to "Turkey" element text:"country" with jsexecutor
    Then I send key to "Balikesir" element text:"city" with jsexecutor
    Then I send key to "12344567878902345" element text:"card" with jsexecutor
    Then I send key to "03" element text:"month" with jsexecutor
    Then I send key to "2024" element text:"year" with jsexecutor
    Then I wait until element to be clickable and click to "order modal purchase button" element
    Then I wait "success icon;thanks for purchase text;ok button" elements
    Then I wait until element to be clickable and click to "ok button" element
    Then  I see "HomePage" page
    Then I wait "categories tab;monitors tab;phones tab;laptops tab" elements
