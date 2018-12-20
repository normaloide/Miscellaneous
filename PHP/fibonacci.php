<?php
$a = 0;    
$b = 1; 
$times = 1;

print $b."<br/>";
while($times < 100) {    
	$k = $a + $b;
	print $k."<br/>";         
	$a = $b;
	$b = $k;
	++$times;   
	}   
?>