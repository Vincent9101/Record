package com.vincent.system.ui.assessment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.vincent.system.R;
import com.vincent.system.data.network.model.patient.PatientRecord;
import com.vincent.system.ui.base.BaseViewHolder;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by IDEA on 2019/4/15
 * User: Vincent
 * Time：11:11
 */
public class PatientAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<PatientRecord> patientRecordList = new ArrayList<>();
    private CallBackPatient callBackPatient;

    public PatientAdapter(CallBackPatient callBackPatient) {
        this.callBackPatient = callBackPatient;
    }

    public void updateList(List<PatientRecord> patientRecords) {
        patientRecordList.clear();
        patientRecordList.addAll(patientRecords);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.patient_item, viewGroup, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View sub = v.findViewById(R.id.patient_sub_layout);
                sub.setVisibility(sub.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(viewGroup.getContext()).setIcon(R.mipmap.ic_launcher).setTitle("删除信息")
                        .setMessage("删除该病例信息么？删除之后不可见").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String id = ((TextView) v.findViewById(R.id.patient_id_item_text)).getText()
                                        .toString();
                                String temp = id.substring(5);
                                callBackPatient.callbackForAsk(temp);
                                dialogInterface.dismiss();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                dialogBuilder.create().show();

                return false;
            }
        });
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);

    }

    @Override
    public int getItemCount() {
        return patientRecordList.size();
    }

    public interface CallBackPatient {
        void callbackForAsk(String patientId);
    }

    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.patient_id_item_text)
        TextView textViewId;
        @BindView(R.id.patient_name_item_text)
        TextView textViewName;
        @BindView(R.id.patient_age_item_text)
        TextView textViewAge;
        @BindView(R.id.patient_final_item_text)
        TextView textViewFinal;

        @BindView(R.id.patient_sub_layout)
        LinearLayout linearLayout;

        @BindView(R.id.patient_lip_remark_item_text)
        TextView textViewFaceRemark;
        @BindView(R.id.patient_face_remark_item_text)
        TextView textViewLipRemark;
        @BindView(R.id.patient_niexia_remark_item_text)
        TextView textViewNiexiaRemark;
        @BindView(R.id.patient_nianmo_remark_item_text)
        TextView textViewNianMoRemark;
        @BindView(R.id.patient_teeth_remark_item_text)
        TextView textViewTeethRemark;
        @BindView(R.id.patient_ruane_remark_item_text)
        TextView textViewRuaneRemark;
        @BindView(R.id.patient_tongue_remark_item_text)
        TextView textViewTongueRemark;
        @BindView(R.id.patient_MWST_remark_item_text)
        TextView textViewMWSTRemark;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            PatientRecord patientRecord = patientRecordList.get(position);
            textViewId.setText("病人ID:" + patientRecord.getPatientId());
            textViewName.setText("姓名：" + patientRecord.getPatientName());
            textViewAge.setText("年龄：" + patientRecord.getPatientAge());
            textViewFinal.setText("最终诊断：" + patientRecord.getStateTemp().getFinalDiagnosis());

            textViewFaceRemark.setText("面部诊断：" + patientRecord.getStateTemp().getFaceStateRemarks());
            textViewLipRemark.setText("嘴唇诊断：" + patientRecord.getStateTemp().getLipStateRemarks());
            textViewNiexiaRemark.setText("颞下颌关节诊断：" + patientRecord.getStateTemp().getJointStateRemarks());
            textViewNianMoRemark.setText("颊粘膜诊断：" + patientRecord.getStateTemp().getMembraneStateRemarks());
            textViewMWSTRemark.setText("改良饮水诊断：" + patientRecord.getStateTemp().getMWSTScoreRemarks());
            textViewTeethRemark.setText("牙齿诊断：" + patientRecord.getStateTemp().getTeethStateRemarks());
            textViewTongueRemark.setText("舌头诊断：" + patientRecord.getStateTemp().getTongueStateRemarks());
            textViewRuaneRemark.setText("软腭诊断：" + patientRecord.getStateTemp().getSoftPalateStateRemarks());
        }

        @Override
        protected void clear() {

        }
    }
}
