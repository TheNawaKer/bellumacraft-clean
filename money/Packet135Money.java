/*
package Bellumacraft.money;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet135Money extends Packet {

        public int playerId;
        public float money;
        
        public Packet135Money(){}
        
        public Packet135Money(EntityPlayer player){
                this.playerId = player.entityId;
                this.money = player.money;
        }
        
        public void readPacketData(DataInputStream datainputstream)
                        throws IOException {
                playerId = datainputstream.readInt();
                money = datainputstream.readFloat();
        }

        public void writePacketData(DataOutputStream dataoutputstream)
                        throws IOException {
                dataoutputstream.writeInt(playerId);
                dataoutputstream.writeFloat(money);
        }

        public void processPacket(NetHandler nethandler) {
                nethandler.handleMoney(this);
        }

        public int getPacketSize() {
                return 12;
        }
}*/