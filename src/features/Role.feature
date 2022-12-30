Feature: Role Creation

Scenario Outline: verify Role Creation with Multiple sets of Data

Given user already on Ranford Home Page

When usser enters valid username and password

Then user Veriffying Admin Login validation

When user Click on Role button

When user Click on New Role and Enters "<RoleName>" and "<RoleType>"

Then user close the Application

Examples:

					| RoleName | RoleType |
					| Ccashierfbc | E |
					| Ttellerfbc | E |
					| Mmanagerfbc | E |
					
															