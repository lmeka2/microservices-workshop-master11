# Micro-Services Assignment Module 3

* Adding New Account 
	*  Endpoint : http://localhost:1001/addAccount
    *  Method : <b>POST</b>
	*  Request JSON : 
	    ````
        {
		    "accountId":0,
		    "balance":29000,
		    "customer":{
		        "customerId":"2",
		        "name":"Anil"
	        }
         }
         ````
         
* Getting All Accounts 
	* Endpoint : http://localhost:1001/getAllAccounts
    * Method : <b>GET</b>
    
* Getting All Accounts 
	* Endpoint : http://localhost:1001/getAllCustomers
    * Method : <b>GET</b>

* Transfering Funds
	* Endpoint : http://localhost:1001/transferFunds
    * Method : <B>POST</b>
    * Request JSON : 
    ````
    {
	    "sourceAccount":"1",
	    "destinationAccount":2,
	    "balance":2000
    }
    ````
    

        
