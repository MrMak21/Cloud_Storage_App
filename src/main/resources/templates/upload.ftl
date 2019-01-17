<!DOCTYPE html>
<html lang="en">
<body>

<h1>Spring Boot file upload example</h1>

<form method="POST" action="/upload" enctype="multipart/form-data">
    <input type="file" name="file" /><br/><br/>
    <input type="submit" value="Submit" />
</form>
<a class="nav-link btn btn-outline-light" href="/logout">Sign out</a>

</body>
</html>
