<%--
  User: eemclaughlin
  Date: 11/24/22
  Page to be called from the main page to display the navigation bar
--%>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <!-- Main Title Button on NavBar -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="navbar-toggler-icon"></span>
        </button> <a class="navbar-brand" href="userHomepage">RecipeWhere?</a>

        <!-- Additional Left Side Buttons on NavBar -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="userHomepage">Recipes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="listCookbooks">Cookbooks</a>
                </li>

                <!-- Dropdown Menu for Adding Things -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">Additions</a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="addRecipe">Add New Recipe</a>
                        <a class="dropdown-item" href="addCookbook.jsp">Add New Cookbook</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-header">Tag Related (Future)</a>
                        <a class="dropdown-item" href="#">List Tag</a>
                        <a class="dropdown-item" href="#">Add New Tags</a>
                    </div>
                </li>
            </ul>

            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </ul>
        </div>
    </nav>