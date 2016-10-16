set vmname Monitor-VM

register broadcastTransmiter com.gft.alpha.service.BroadcastTransmiterService
register broadcastReceiver com.gft.alpha.service.BroadcastReceiverService
register tcpserver com.gft.alpha.service.TCPServerService

start broadcastTransmiter 192.168.1.255 5000 5009 monitor:192.168.1.83:5000;
start broadcastReceiver 5001
start tcpserver 5000