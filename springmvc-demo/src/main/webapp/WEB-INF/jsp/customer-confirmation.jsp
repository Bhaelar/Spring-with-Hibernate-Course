<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

	<head>
		<title>Customer Confirmation</title>
	</head>
	
	<body>
		The customer is confirmed: ${customer.firstName}, ${customer.lastName}
		
		<br />
		
		Free passes: ${customer.freePasses}
		
		<br />
		
		Postal code: ${customer.postalCode}
	</body>
</html>