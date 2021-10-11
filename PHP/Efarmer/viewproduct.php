<?php
include "fmconfig.php";

	$query="SELECT * From sproduct";
	
	$res=mysqli_query($conn,$query);
	
	$result1=array();
	
	while($row=mysqli_fetch_array($res))
	{
		array_push($result1,
		array(
				'fertname'=>$row[1],
				'image'=>$row[2],
				'rate'=>$row[3],
				'description'=>$row[4],
	
				));
	}
	
	echo json_encode(array("result"=>$result1));
	mysqli_close($conn);
?>