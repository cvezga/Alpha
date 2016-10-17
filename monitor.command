set vmname Monitor-VM
set ip 192.168.1.83
set port 5000

register broadcastTransmiter com.gft.alpha.net.service.BroadcastTransmiterService
register broadcastReceiver com.gft.alpha.net.service.BroadcastReceiverService
register tcpserver com.gft.alpha.net.service.TCPServerService
register pulse com.gft.alpha.net.service.PulseService

provide-service S-PULSE-SERVICE com.gft.alpha.net.handler.PulseServiceHandler
provide-service Q-MONITOR-SERVICE com.gft.alpha.net.handler.MonitorQueryServiceHandler

start broadcastTransmiter 192.168.1.255 5000 5009 60000 SUBSCRIBE:S-PULSE-SERVICE:192.168.1.83:5000;
start broadcastReceiver 5000
start tcpserver 5000
start pulse 15000

