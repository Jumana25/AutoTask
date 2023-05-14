Feature: Validations of Subscription Packages

  Scenario Outline: Validate Subscription Packages for specific countries.
    Given I Open the target browser
    And Navigate to URL "https://subscribe.stctv.com/"
    And Switch current language
    When I set country "<Country>"
    Then I should see correct currency displayed "<Expected_Currency>"
    Then I should see correct price displayed "<Price_Lite>" for lite plan
    Then I should see correct price displayed "<Price_Classic>" for classic plan
    Then I should see correct price displayed "<Price_Premium>" for premium plan

    Examples:
      | Country | Expected_Currency | Price_Lite | Price_Classic | Price_Premium |
      | UAE     | AED               | 5.4        | 10.9          | 16.3          |
      | Tunisia | TND/week          | 1.7        | 3.4           | 5.8           |