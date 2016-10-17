set vmname Sequencer-VM
set ip 192.168.1.83
set port 5001

register broadcastTransmiter com.gft.alpha.net.service.BroadcastTransmiterService
register broadcastReceiver com.gft.alpha.net.service.BroadcastReceiverService
register tcpserver com.gft.alpha.net.service.TCPServerService
register pulse com.gft.alpha.net.service.PulseService

provide-service S-SEQUENCER-SERVICE com.gft.alpha.net.handler.PulseServiceHandler

start broadcastTransmiter 192.168.1.255 5000 5009 60000 SUBSCRIBE:S-PULSE-SERVICE:192.168.1.83:5001;
start broadcastReceiver 5001
start tcpserver 5001
start pulse 15000

