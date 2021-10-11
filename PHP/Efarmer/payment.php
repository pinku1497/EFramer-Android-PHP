<?php
	
	include "fmconfig.php";
	
	$name=$_GET['name'];
	$cardnum=$_GET['cardnum'];
	$cvv=$_GET['cvv'];
	$expirydate=$_GET['expirydate'];
	
	$sql="insert into payment(name,cardnum,cvv,expirydate)values('$name','$cardnum','$cvv','$expirydate')";
	
	
	$res=mysqli_query($conn,$sql);
	$result=array();
	
	if($res)
	{
		array_push($result,
							array('status'=>1,
								'msg'=>"Payment Succesfully.."));
	}
	else
	{
		array_push($result,
							array('status'=>0,
							'msg'=>"Payment unsucces,TRY Again"));
	}

	echo json_encode(array("result"=>$result));
	
	
	
?>