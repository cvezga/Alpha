import services.command

set vmname Cesar-Terminal-Test-VM-1

start brocastTransmiter 10.230.20.255 5000 5009 master:$myip:5000 
start terminal 5001