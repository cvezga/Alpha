set vmname Sequencer-VM
set ip 10.230.20.21
set port 5001
set terminalPort 5101

import common.command

provide-service S-SEQUENCER-SERVICE com.gft.alpha.net.handler.PulseServiceHandler
