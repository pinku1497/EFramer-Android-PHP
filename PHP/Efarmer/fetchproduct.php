<?php
include "fmconfig.php";

$query = "SELECT * FROM sproduct"; 

$res = mysqli_query($conn,$query);

$result1 = array();
 
while($row=mysqli_fetch_array($res)){
	
array_push($result1,
      array(

			'fertname'=>$row[1]
			));
}
 
echo json_encode(array("result"=>$result1));
mysqli_close($conn);

?>