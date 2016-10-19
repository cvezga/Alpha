set udpPortMin 5000
set udpPortMax 5009

register broadcastTransmiter com.gft.alpha.net.service.BroadcastTransmiterService
register broadcastReceiver com.gft.alpha.net.service.BroadcastReceiverService
register tcpserver com.gft.alpha.net.service.TCPServerService
register pulse com.gft.alpha.net.service.PulseService
register terminal com.gft.alpa.service.terminal.TerminalService

start broadcastTransmiter 3000 SUBSCRIBE:S-PULSE-SERVICE
start broadcastReceiver
start tcpserver
start pulse 5000
start terminal
