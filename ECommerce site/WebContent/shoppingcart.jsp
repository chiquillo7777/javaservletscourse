<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="include/header.jsp"><c:param name="title" value="Demo Page"/></c:import>
    <div class="container mtb">
        <div class="row">
            <div class="col-lg-6">
                <h1>These are the items in your shopping cart</h1>
                
                <h1>PRODUCT CATALOG</h1>
                <form method="get" action="ShoppingCartController?operation=shoppingcart">
                    <table border="1">
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>category</th>
                            <th>price</th>
                            <th>Options</th>  
                        </tr>

                    <c:forEach items= "${productsListShoppingCart}" var="productsList">

                        <tr>
                            <td>${productsListShoppingCart.id}</td>
                            <td>${productsListShoppingCart.name}</td>
                            <td>${productsListShoppingCart.description}</td>
                            <td>${productsListShoppingCart.category}</td>
                            <td>${productsListShoppingCart.price}</td>

                           
                            <td><a href="http://localhost:8080/ShoppingCartController?operation=addproduct&id=${productsList.id}">Remove</a></td>
                        </tr>
                    </c:forEach>
            </form>
            </table>
            </div>
        </div>
    </div>
<c:import url="include/footer.jsp"></c:import>