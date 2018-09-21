package andrekabelim.br.projetomaxmilhas.ui.view;

import andrekabelim.br.projetomaxmilhas.ui.models.Data;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void navigateToFligthPage(Data data);
    void showAlert(String message);
}
