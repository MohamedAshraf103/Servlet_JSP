<%@page import="com.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- *****************************************************************************************************************
       OUR CLIENTS
       ***************************************************************************************************************** -->
<div id="cwrap">
    <div class="container">
        <div class="row centered">
            <h3>This Is All Products</h3>
            <table border="0" width="75%">
                    <tr>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Product Price</th>
                        <th>Product Category</th>
                         <th>Product Description</th>
                    </tr>
                 <%
                        ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
                        for (Product product : products) { 
                        	out.println("ID"+product.getId());
                        }
                    %>
                    
                    
            </table>

        </div>
    </div>
</div>
