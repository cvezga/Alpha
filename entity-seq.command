import services.command

set vmname Entity-Sequencer-VM

start entitySeqService
start brocastTransmiter 10.230.20.255 5000 5009 entity-seq:$myip:5000 
