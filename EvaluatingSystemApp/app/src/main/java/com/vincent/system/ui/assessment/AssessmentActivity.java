package com.vincent.system.ui.assessment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.vincent.system.R;
import com.vincent.system.data.network.model.patient.PatientRecord;
import com.vincent.system.ui.assessment.business.AddPatientRecordActivity;
import com.vincent.system.ui.base.BaseActivity;

import javax.inject.Inject;
import java.util.List;

public class AssessmentActivity extends BaseActivity implements AssessmentMvpView, PatientAdapter.CallBackPatient {

    @Inject
    AssessmentMvpPresenter<AssessmentMvpView> presenter;

    @Inject
    LinearLayoutManager mLayoutManager;


    @BindView(R.id.toolbar_assessment)
    Toolbar mToolbar;

    @BindView(R.id.patient_recycler)
    RecyclerView recyclerView;

    private PatientAdapter patientAdapter = new PatientAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);
        getActivityComponent().inject(this);
        presenter.onAttach(this);
        setUnBinder(ButterKnife.bind(this));
        setUp();

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getPatientRecord();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setClick
        recyclerView.setAdapter(patientAdapter);
        presenter.getPatientRecord();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.action_add_patient:
                startActivity(AddPatientRecordActivity.getStartIntent(this));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.assessment, menu);
        return true;
    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, AssessmentActivity.class);
    }

    @Override
    public void onGetPatientRecord(List<PatientRecord> list) {
        patientAdapter.updateList(list);
    }

    @Override
    public void onDeleteCompleted() {
        presenter.getPatientRecord();
    }

    @Override
    public void callbackForAsk(String id) {
        presenter.deletePatientRecord(id);
    }
}
