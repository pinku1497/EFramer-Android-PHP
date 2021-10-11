<?php
	
	include "fmconfig.php";
	
	$srname=$_GET['srname'];
	$sremail=$_GET['sremail'];
	$srpass=$_GET['srpass'];
	$srcpass=$_GET['srcpass'];
	
	$sql="insert into sellerreg(srname,sremail,srpass,srcpass)values('$srname','$sremail','$srpass','$srcpass')";
	
	
	$res=mysqli_query($conn,$sql);
	$result=array();
	if($res)
	{
		array_push($result,
							array('status'=>1,
								'msg'=>"Registration Succesfully.."));
	}
	else
	{
		array_push($result,
							array('status'=>0,
							'msg'=>"Registration unsucces,TRY Again"));
	}

	echo json_encode(array("result"=>$result));
	
	
	
?>