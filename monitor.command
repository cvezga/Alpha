set vmname Monitor-VM
set ip 192.168.1.83

register broadcastTransmiter com.gft.alpha.net.service.BroadcastTransmiterService
register broadcastReceiver com.gft.alpha.net.service.BroadcastReceiverService
register tcpserver com.gft.alpha.net.service.TCPServerService

start broadcastTransmiter 192.168.1.255 5000 5009 monitor:192.168.1.83:5000;
start broadcastReceiver 5000
start tcpserver 5000