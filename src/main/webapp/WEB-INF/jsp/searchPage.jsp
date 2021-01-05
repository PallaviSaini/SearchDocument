<!DOCTYPE html>
<html lang="en">
<body id="SearchDocumentForm" bgcolor="#ffffcc">
<h2>Search Document</h2>
<p>Please enter your Search Word</p>
<form id="SearchDocumentForm" action="/searchDocument/searchOnBasisOfChoice">

 <TABLE style="background-color: #ECE5B6;" WIDTH="50%">
                <tr width="100%">
                    <td >Search Word</td>
                    <td ><input type="text" name="searchWord"></td>
                </tr>
                <tr>
                    <td width="20%">Search Method</td>
                    <td width="25%"><input type="radio" name="choice" value="SM">String Match</td>
                    <td width="30%"><input type="radio" name="choice" value="RE" checked>Regular Expression</td>
                    <td width="25%"><input type="radio" name="choice" value="IM">Indexed</td>
                </tr>
				<tr><td></td><td></td>
				<td><input type="submit" name="submit" value="submit"></td></tr>
 </TABLE>
</form>
</body>

</html>