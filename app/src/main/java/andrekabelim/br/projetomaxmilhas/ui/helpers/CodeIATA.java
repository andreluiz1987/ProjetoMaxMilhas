package andrekabelim.br.projetomaxmilhas.ui.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import andrekabelim.br.projetomaxmilhas.ui.models.Airport;

public class CodeIATA {

    public static ArrayList<Airport> getListIATA() {

        ArrayList<Airport> airports = new ArrayList<>();
        Map<String, String> map = getIATACodes();

        for (Map.Entry<String, String> entry : map.entrySet()) {

            Airport airport = new Airport();

            airport.code = entry.getKey();
            airport.name = entry.getValue();

            airports.add(airport);
        }

        return airports;
    }

    public static Map<String, String> getIATACodes() {

        Map<String, String> map = new HashMap<>();

        map.put("AJU", "Aeroporto Santa Maria, Aracaju (SE)");
        map.put("BEL", "Aeroporto Val de Caes, Belém (PA)");
        map.put("BGX", "Aeroporto de Bagé (RS)");
        map.put("BNU", "Aeroporto de Blumenau (SC)");
        map.put("BPS", "Aeroporto de Porto Seguro (BA)");
        map.put("BSB", "Aeroporto Juscelino Kubitschek, Brasília (DF)");
        map.put("BVB", "Aeroporto de Boa Vista RO)");
        map.put("CAC", "Aeroporto de Cascavel (PR)");
        map.put("CFB", "Aeroporto de Cabo Frio (RJ)");
        map.put("CGB", "Aeroporto de Cuiabá (MT)");
        map.put("CGH", "Aeroporto de Congonhas, São Paulo (SP)");
        map.put("CGR", "Aeroporto de Campo Grande (MS)");
        map.put("CNF", "Aeroporto de Confins, Belo Horizonte (MG)");
        map.put("CPV", "Aeroporto João Suassuna, Campina Grande (PB)");
        map.put("CWB", "Aeroporto Afonso Pena, Curitiba (PR)");
        map.put("CXJ", "Aeroporto de Caxias do Sul (RS)");
        map.put("FLN", "Aeroporto de Florianópolis (SC)");
        map.put("FOR", "Aeroporto Pinto Martins, Fortaleza (CE)");
        map.put("GIG", "Aeroporto do Galeão, Rio de Janeiro (RJ)");
        map.put("GPB", "Aeroporto de Guarapuava (PR)");
        map.put("GRU", "Aeroporto Franco Montoro, em Guarulhos, São Paulo (SP)");
        map.put("GYN", "Aeroporto de Goiânia (GO)");
        map.put("IGU", "Aeroporto das Cataratas, Foz do Iguaçu (PR)");
        map.put("IMP", "Aeroporto Prefeito Renato Moreira, Imperatriz (MA)");
        map.put("IOS", "Aeroporto de Ilhéus (BA)");
        map.put("JDO", "Aeroporto do Cariri, Juazeiro do Norte (CE)");
        map.put("JOI", "Aeroporto de Joinville (SC)");
        map.put("JPA", "Aeroporto Pres. Castro Pinto, João Pessoa (PB)");
        map.put("LDB", "Aerooporto de Londrina (PR)");
        map.put("LAJ", "Aeroporto de Lages (RS)");
        map.put("MAO", "Aeroporto Eduardo Gomes, Manaus (AM)");
        map.put("MCZ", "Aeroporto Zumbi dos Palmares, Maceió (AL)");
        map.put("MGF", " Aeroporto de Maringá (PR)");
        map.put("MVF", "Aeroporto de Mossoró (RN)");
        map.put("NAT", "Aeroporto Augusto Severo, Natal (RN)");
        map.put("PET", "Aeroporto de Pelotas (RS)");
        map.put("PLU", "Aeroporto da Pampulha, Belo Horizonte (MG)");
        map.put("PHB", "Aeroporto de Parnaíba (PI)");
        map.put("PFB", "Aeroporto de Passo Fundo (RS)");
        map.put("PMW", " Aeroporto de Palmas (TO)");
        map.put("PNZ", "Aeroporto de Petrolina (PE)");
        map.put("POA", "Aeroporto Salgado Filho, Porto Alegre (RS)");
        map.put("REC", "Aeroporto dos Guararapes, Recife (PE)");
        map.put("RIA", "Aeroporto de Santa Maria (RS)");
        map.put("SDU", " Aeroporto Santos Dumont, Rio de Janeiro (RJ)");
        map.put("SLZ", " Aeroporto Marechal Cunha Machado, São Luis (MA)");
        map.put("SOD", "Aeroporto de Sorocaba (SP)");
        map.put("SSA", "Aeroporto de Salvador (BA)");
        map.put("THE", "Aeroporto Senador Petrônio Portela, Teresina (PI)");
        map.put("VCP", "Aeroporto de Viracopos, em Campinas (SP)");
        map.put("UDI", "Aeroporto de Uberlândia (MG)");
        map.put("VDC", "Aeroporto de Vitória da Conquista (BA)");
        map.put("VIX", "Aeroporto de Vitória (ES)");
        map.put("XAP", "Aeroporto de Chapecó (SC)");

        return map;
    }
}
