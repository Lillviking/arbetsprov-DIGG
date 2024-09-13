import org.springframework.stereotype.Service;

import com.kundhantering.model.Kund;

import java.util.ArrayList;
import java.util.List;

@Service
public class KundService {

    private List<Kund> kunder = new ArrayList<>();

    public void addKund(Kund kund) {
        kunder.add(kund);
    }

    public List<Kund> getAllKunder() {
        return kunder;
    }
}
