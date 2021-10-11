<?php
include "fmconfig.php";
error_reporting(E_ALL);
if(isset($_POST['image']))
{
	$img = $_POST['fertname'];
	$img = $_POST['image'];
	$img = $_POST['rate'];
	$img = $_POST['description'];
$imsrc = str_replace(' ','+',$_POST['base64']);
$imsrc = base64_decode($imsrc);
$fp = fopen($img, 'w');
fwrite($fp, $imsrc);
if(fclose($fp)){
	echo "Image uploaded";
}else{
	echo "Error uploading image";
}
}
?>