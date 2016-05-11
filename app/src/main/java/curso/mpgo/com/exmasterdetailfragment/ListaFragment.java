package curso.mpgo.com.exmasterdetailfragment;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by ricardoogliari on 5/11/16.
 */
public class ListaFragment extends ListFragment {

    String[] times;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        times = new String[]{
                getString(R.string.goias),
                getString(R.string.atletico),
                getString(R.string.vila),
                getString(R.string.crac),
                getString(R.string.gremio)
        };

        setListAdapter(
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, times)
        );
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        DetalheFragment detalheFragment =
                (DetalheFragment)getActivity().getFragmentManager().findFragmentById(R.id.detalheFragment);

        if (detalheFragment == null || !detalheFragment.isInLayout()){
            Intent intent = new Intent(getActivity(), DetalheActivity.class);
            intent.putExtra("time", times[position]);
            startActivityForResult(intent, MainActivity.REQ_DETALHE);
        } else {
            detalheFragment.setText(times[position]);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MainActivity.REQ_DETALHE){
            if (resultCode == getActivity().RESULT_CANCELED){
                String time = data.getStringExtra("time");
                ((DetalheFragment)getFragmentManager().findFragmentById(R.id.detalheFragment)).setText(time);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
