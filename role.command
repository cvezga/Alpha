set vmname Role-VM
set ip 192.168.1.83
set port 5004

register broadcastTransmiter com.gft.alpha.net.service.BroadcastTransmiterService
register broadcastReceiver com.gft.alpha.net.service.BroadcastReceiverService
register tcpserver com.gft.alpha.net.service.TCPServerService
register pulse com.gft.alpha.net.service.PulseService
register terminal com.gft.alpa.service.terminal.TerminalService

load role.txt

provide-service Q-ROLE-SERVICE com.gft.alpha.net.handler.QueryServiceHandler

start broadcastTransmiter 192.168.1.255 5000 5009 3000 SUBSCRIBE:S-PULSE-SERVICE:192.168.1.83:5004;
start broadcastTransmiter 192.168.1.255 5000 5009 3000 SUBSCRIBE:S-SEQUENCER-SERVICE:192.168.1.83:5004;
start broadcastReceiver 5004
start tcpserver 5004
start pulse 15000
start terminal 5104
