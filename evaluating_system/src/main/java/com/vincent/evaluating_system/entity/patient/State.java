package com.vincent.evaluating_system.entity.patient;

/**
 * Created by IDEA on 2019/4/8
 * User: Vincent
 * Time：11:13
 */
public interface State {

//    前端写死

    enum FaceState {


        PARALYSIS_F(false, "无单双侧麻痹"),

        PARALYSIS_T(true, "有单双侧麻痹"),

        SPASM_F(false, "无单双侧痉挛"),

        SPASM_T(true, "有单双侧痉挛"),

        DROPPING_EYE_F(false, "无眼脸下垂"),

        DROPPING_EYE_T(true, "有眼脸下垂"),

        DROPPING_MOUTH_F(false, "无嘴角下垂"),

        DROPPING_MOUTH_T(true, "有嘴角下垂");

        private final boolean value;
        private final String desc;


        FaceState(boolean value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public static String getDesc(int index, boolean flag) throws Exception {
            String descRes = null;
            switch (index) {
                case 0:
                    descRes = flag ? PARALYSIS_T.desc : PARALYSIS_F.desc;
                    break;
                case 1:
                    descRes = flag ? SPASM_T.desc : SPASM_F.desc;
                    break;
                case 2:
                    descRes = flag ? DROPPING_EYE_T.desc : DROPPING_EYE_F.desc;
                    break;
                case 3:
                    descRes = flag ? DROPPING_MOUTH_T.desc : DROPPING_MOUTH_F.desc;
                    break;
                default:
                    throw new Exception("index 不可以超出3");
            }

            return descRes;
        }
    }

    enum LipState {
        LIP_ACTIVE_NATURALLY_T(true, "抿嘴动作自然"),
        LIP_ACTIVE_NATURALLY_F(false, "抿嘴动作不自然"),

        GRINNING_WHISTLE_T(true, "吹口哨露齿动作自然"),
        GRINNING_WHISTLE_F(false, "吹口哨露齿动作不自然");


        private final boolean value;
        private final String desc;

        LipState(boolean value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public static String getDesc(int index, boolean flag) throws Exception {
            String descRes = null;
            switch (index) {
                case 0:
                    descRes = flag ? LIP_ACTIVE_NATURALLY_T.desc : LIP_ACTIVE_NATURALLY_F.desc;
                    break;
                case 1:
                    descRes = flag ? GRINNING_WHISTLE_T.desc : GRINNING_WHISTLE_F.desc;
                    break;
                default:
                    throw new Exception("index 不可以超出1");
            }

            return descRes;
        }

    }

    enum JointState {
        JOINT_INITIATIVE_NATURALLY_T(true, "主动开合动作自然"),
        JOINT_INITIATIVE_NATURALLY_F(false, "主动开合动作不自然"),

        JOINT_PASSIVE_NATURALLY_T(true, "被动开合动作自然"),
        JOINT_PASSIVE_NATURALLY_F(false, "被动开合动作不自然"),


        JOINT_INIATIVE_NATURALLY_GRIND_T(true, "主动研磨动作自然"),
        JOINT_INIATIVE_NATURALLY_GRIND_F(false, "主动研磨动作不自然"),

        JOINT_PASSIVE_NATURALLY_GRIND_T(true, "被动研磨动作自然"),
        JOINT_PASSIVE_NATURALLY_GRIND_F(false, "被动研磨动作不自然");


        private final boolean value;
        private final String desc;

        JointState(boolean value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public static String getDesc(int index, boolean flag) throws Exception {
            String descRes = null;
            switch (index) {
                case 0:
                    descRes = flag ? JOINT_INITIATIVE_NATURALLY_T.desc : JOINT_INITIATIVE_NATURALLY_F.desc;
                    break;
                case 1:
                    descRes = flag ? JOINT_PASSIVE_NATURALLY_T.desc : JOINT_PASSIVE_NATURALLY_F.desc;
                    break;
                case 2:
                    descRes = flag ? JOINT_INIATIVE_NATURALLY_GRIND_T.desc : JOINT_INIATIVE_NATURALLY_GRIND_F.desc;
                    break;
                case 3:
                    descRes = flag ? JOINT_PASSIVE_NATURALLY_GRIND_T.desc : JOINT_PASSIVE_NATURALLY_GRIND_F.desc;
                    break;

                default:
                    throw new Exception("index 不可以超出3");
            }

            return descRes;
        }

    }

    enum MembraneState {
        HEMATOMA_T(true, "有血肿"),
        HEMATOMA_F(false, "无血肿"),

        DAMAGED_T(true, "有破损"),
        DAMAGED_F(false, "无破损"),

        ANABROSIS_T(true, "有溃疡"),
        ANABROSIS_F(false, "无溃疡");


        private final boolean value;
        private final String desc;

        MembraneState(boolean value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public static String getDesc(int index, boolean flag) throws Exception {
            String descRes = null;
            switch (index) {
                case 0:
                    descRes = flag ? HEMATOMA_T.desc : HEMATOMA_F.desc;
                    break;
                case 1:
                    descRes = flag ? DAMAGED_T.desc : DAMAGED_F.desc;
                    break;
                case 2:
                    descRes = flag ? ANABROSIS_T.desc : ANABROSIS_F.desc;
                    break;

                default:
                    throw new Exception("index 不可以超出2");
            }

            return descRes;
        }

    }

    enum TeethState {
        DECAYED_TEETH_T(true, "有龋齿"),
        DECAYED_TEETH_F(false, "无龋齿"),

        LOOSE_TEETH_T(true, "有牙齿松动"),
        LOOSE_TEETH_F(false, "无松牙齿动");


        private final boolean value;
        private final String desc;

        TeethState(boolean value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public static String getDesc(int index, boolean flag) throws Exception {
            String descRes = null;
            switch (index) {
                case 0:
                    descRes = flag ? DECAYED_TEETH_T.desc : DECAYED_TEETH_F.desc;
                    break;
                case 1:
                    descRes = flag ? LOOSE_TEETH_T.desc : LOOSE_TEETH_F.desc;
                    break;
                default:
                    throw new Exception("index 不可以超出1");
            }
            return descRes;
        }

    }

    enum SoftPalateState {

        NASAL_LEAKAGE_T(true, "有鼻腔漏气情况"),
        NASAL_LEAKAGE_F(false, "无鼻腔漏气情况");


        private final boolean value;
        private final String desc;

        SoftPalateState(boolean value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public static String getDesc(boolean flag) {
            String descRes = null;
            descRes = flag ? NASAL_LEAKAGE_T.desc : NASAL_LEAKAGE_F.desc;
            return descRes;
        }

    }

    enum TongueState {

        ACTIVE_NATURALLY_T(true, "舌头伸展活动正常"),
        ACTIVE_NATURALLY_F(false, "舌头伸展活动异常"),

        GUSTATION_T(true, "味觉正常"),
        GUSTATION_F(false, "味觉异常");


        private final boolean value;
        private final String desc;

        TongueState(boolean value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public static String getDesc(int index, boolean flag) throws Exception {
            String descRes = null;
            switch (index) {
                case 0:
                    descRes = flag ? ACTIVE_NATURALLY_T.desc : ACTIVE_NATURALLY_F.desc;
                    break;
                case 1:
                    descRes = flag ? GUSTATION_T.desc : GUSTATION_F.desc;
                    break;
                default:
                    throw new Exception("index 不可以超出1");
            }

            return descRes;
        }

    }
}

