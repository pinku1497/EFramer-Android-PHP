<?php
include "fmconfig.php";

$query = "SELECT * FROM package"; 

$res = mysqli_query($conn,$query);

$result1 = array();
 
while($row=mysqli_fetch_array($res)){
	
array_push($result1,
      array(

			'packagename'=>$row[1],
			'duration'=>$row[2],
			'rate'=>$row[3],
			'descripton'=>$row[4]
			));
}
 
echo json_encode(array("result"=>$result1));
mysqli_close($conn);

?>