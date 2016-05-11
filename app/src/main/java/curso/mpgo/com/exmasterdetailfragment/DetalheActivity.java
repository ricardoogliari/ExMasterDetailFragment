package curso.mpgo.com.exmasterdetailfragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String time = getIntent().getStringExtra("time");

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Intent i = new Intent();
            i.putExtra("time", time);
            setResult(RESULT_CANCELED, i);
            finish();
        }

        setContentView(R.layout.activity_detalhe);

        DetalheFragment frag =
                (DetalheFragment)getFragmentManager().findFragmentById(R.id.detalheFragment);
        frag.setText(time);
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }
}
