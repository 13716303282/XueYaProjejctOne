package kdxf.zzh.com.xueyaprojejct.bean;

import java.util.List;

/**
 * Created by ASUS on 2018/11/21.
 */

public class Timetable {

    /**
     * result : 1
     * msg :
     * data : {"id":"1179","name":"郭永庆","title":"主任医师","teach":"教授","goodat":"肺癌、食管癌、纵隔肿瘤的外科治疗，胸腔镜肺叶切除手术，胸腔镜全胸腺切除治疗重症肌无力，支气管扩张支气管剔除术，肺减容术，肺移植；治疗顽固性恶性胸水。","photo":"http://static.i2.xywy.com/zhuanjia/20141212/98053d6a17af1f21c0273da1e2bbef3d87086_a.jpg","info":"郭永庆，男，主任医师，北京大学医学部教授，硕士研究生导师，胸外科副主任，肺癌中心副主任，专业特长：从事胸外科工作28年，具有较强的胸外科功底，擅长肺癌、食管癌、纵隔肿瘤的外科治疗，胸腔镜肺叶切除手术，胸腔镜全胸腺切除治疗重症肌无力，支气管扩张支气管剔除术，肺减容术，肺移植；治疗顽固性恶性胸水。专攻肺癌的早期诊断及基础研究。\r\n\r\n　　中华医学会北京市胸外科专业委员会会员，中国中西医结合学会肿瘤专业委员会常委，中国综合临床杂志编委，北京市医疗事故鉴定专家，中华医学会科技成果评审专家。\r\n\r\n　　学习工作经历：1983年毕业于白求恩医科大学，1997年协和医科大学硕士毕业。曾到日本国立癌中心和瑞典卡洛琳斯卡医学研究院访问学习2年。2006年和2010年分别在美国华盛顿大学医学院Barnes jewish医院和意大利锡耶纳大学学习，公派访问学者。\r\n\r\n　　获国家科研项目1项，培养硕士生3名。多次参加国内、外学术会议，发表论文26篇，参编著作3部，译著1部。","pinyin":"guoyongqing","expertId":"1297","answernum":"0","is_ask":"1","is_plus":"1","hospital":"中日友好医院","depart":"胸外科","plusNum":"40","schedule":{"rdtime":[{"title":"2018-11-26 星期一 上午 专家门诊","id":"987","date":"1543161600","week":"1","halfday":"1","type":"2","state":"1","money":"14","address":"门诊楼三楼（9点半之前到）","msg":"申请预约","already_num":"0","amount":"10","surplus":"10"},{"title":"2018-12-03 星期一 上午 专家门诊","id":"987","date":"1543766400","week":"1","halfday":"1","type":"2","state":"1","money":"14","address":"门诊楼三楼（9点半之前到）","msg":"申请预约","already_num":"0","amount":"10","surplus":"10"},{"title":"2018-12-10 星期一 上午 专家门诊","id":"987","date":"1544371200","week":"1","halfday":"1","type":"2","state":"1","money":"14","address":"门诊楼三楼（9点半之前到）","msg":"申请预约","already_num":"0","amount":"10","surplus":"10"}],"rddate":["2018-11-26","2018-12-03","2018-12-10"],"num":{"total":"3","res_num":"3"}},"plus_require":"从事胸外科工作26年，具有较强的胸外科功底，擅长肺癌、食管癌、纵隔肿瘤的外科治疗，胸腔镜肺叶切除手术，胸腔镜全胸腺切除治疗重症肌无力，支气管扩张支气管剔除术，肺减容术，肺移植;治疗顽固性恶性胸水。专攻肺癌的早期诊断及基础研究。","expert_pinyin":"guoyongqing","address":"北京市朝阳区樱花园东街2号"}
     */

    private int result;
    private String msg;
    private Datauser data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Datauser getData() {
        return data;
    }

    public void setData(Datauser data) {
        this.data = data;
    }

    public static class Datauser {
        /**
         * id : 1179
         * name : 郭永庆
         * title : 主任医师
         * teach : 教授
         * goodat : 肺癌、食管癌、纵隔肿瘤的外科治疗，胸腔镜肺叶切除手术，胸腔镜全胸腺切除治疗重症肌无力，支气管扩张支气管剔除术，肺减容术，肺移植；治疗顽固性恶性胸水。
         * photo : http://static.i2.xywy.com/zhuanjia/20141212/98053d6a17af1f21c0273da1e2bbef3d87086_a.jpg
         * info : 郭永庆，男，主任医师，北京大学医学部教授，硕士研究生导师，胸外科副主任，肺癌中心副主任，专业特长：从事胸外科工作28年，具有较强的胸外科功底，擅长肺癌、食管癌、纵隔肿瘤的外科治疗，胸腔镜肺叶切除手术，胸腔镜全胸腺切除治疗重症肌无力，支气管扩张支气管剔除术，肺减容术，肺移植；治疗顽固性恶性胸水。专攻肺癌的早期诊断及基础研究。

         　　中华医学会北京市胸外科专业委员会会员，中国中西医结合学会肿瘤专业委员会常委，中国综合临床杂志编委，北京市医疗事故鉴定专家，中华医学会科技成果评审专家。

         　　学习工作经历：1983年毕业于白求恩医科大学，1997年协和医科大学硕士毕业。曾到日本国立癌中心和瑞典卡洛琳斯卡医学研究院访问学习2年。2006年和2010年分别在美国华盛顿大学医学院Barnes jewish医院和意大利锡耶纳大学学习，公派访问学者。

         　　获国家科研项目1项，培养硕士生3名。多次参加国内、外学术会议，发表论文26篇，参编著作3部，译著1部。
         * pinyin : guoyongqing
         * expertId : 1297
         * answernum : 0
         * is_ask : 1
         * is_plus : 1
         * hospital : 中日友好医院
         * depart : 胸外科
         * plusNum : 40
         * schedule : {"rdtime":[{"title":"2018-11-26 星期一 上午 专家门诊","id":"987","date":"1543161600","week":"1","halfday":"1","type":"2","state":"1","money":"14","address":"门诊楼三楼（9点半之前到）","msg":"申请预约","already_num":"0","amount":"10","surplus":"10"},{"title":"2018-12-03 星期一 上午 专家门诊","id":"987","date":"1543766400","week":"1","halfday":"1","type":"2","state":"1","money":"14","address":"门诊楼三楼（9点半之前到）","msg":"申请预约","already_num":"0","amount":"10","surplus":"10"},{"title":"2018-12-10 星期一 上午 专家门诊","id":"987","date":"1544371200","week":"1","halfday":"1","type":"2","state":"1","money":"14","address":"门诊楼三楼（9点半之前到）","msg":"申请预约","already_num":"0","amount":"10","surplus":"10"}],"rddate":["2018-11-26","2018-12-03","2018-12-10"],"num":{"total":"3","res_num":"3"}}
         * plus_require : 从事胸外科工作26年，具有较强的胸外科功底，擅长肺癌、食管癌、纵隔肿瘤的外科治疗，胸腔镜肺叶切除手术，胸腔镜全胸腺切除治疗重症肌无力，支气管扩张支气管剔除术，肺减容术，肺移植;治疗顽固性恶性胸水。专攻肺癌的早期诊断及基础研究。
         * expert_pinyin : guoyongqing
         * address : 北京市朝阳区樱花园东街2号
         */

        private String id;
        private String name;
        private String title;
        private String teach;
        private String goodat;
        private String photo;
        private String info;
        private String pinyin;
        private String expertId;
        private String answernum;
        private String is_ask;
        private String is_plus;
        private String hospital;
        private String depart;
        private String plusNum;
        private Scheduleuser schedule;
        private String plus_require;
        private String expert_pinyin;
        private String address;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTeach() {
            return teach;
        }

        public void setTeach(String teach) {
            this.teach = teach;
        }

        public String getGoodat() {
            return goodat;
        }

        public void setGoodat(String goodat) {
            this.goodat = goodat;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getExpertId() {
            return expertId;
        }

        public void setExpertId(String expertId) {
            this.expertId = expertId;
        }

        public String getAnswernum() {
            return answernum;
        }

        public void setAnswernum(String answernum) {
            this.answernum = answernum;
        }

        public String getIs_ask() {
            return is_ask;
        }

        public void setIs_ask(String is_ask) {
            this.is_ask = is_ask;
        }

        public String getIs_plus() {
            return is_plus;
        }

        public void setIs_plus(String is_plus) {
            this.is_plus = is_plus;
        }

        public String getHospital() {
            return hospital;
        }

        public void setHospital(String hospital) {
            this.hospital = hospital;
        }

        public String getDepart() {
            return depart;
        }

        public void setDepart(String depart) {
            this.depart = depart;
        }

        public String getPlusNum() {
            return plusNum;
        }

        public void setPlusNum(String plusNum) {
            this.plusNum = plusNum;
        }

        public Scheduleuser getSchedule() {
            return schedule;
        }

        public void setSchedule(Scheduleuser schedule) {
            this.schedule = schedule;
        }

        public String getPlus_require() {
            return plus_require;
        }

        public void setPlus_require(String plus_require) {
            this.plus_require = plus_require;
        }

        public String getExpert_pinyin() {
            return expert_pinyin;
        }

        public void setExpert_pinyin(String expert_pinyin) {
            this.expert_pinyin = expert_pinyin;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public static class Scheduleuser {
            /**
             * rdtime : [{"title":"2018-11-26 星期一 上午 专家门诊","id":"987","date":"1543161600","week":"1","halfday":"1","type":"2","state":"1","money":"14","address":"门诊楼三楼（9点半之前到）","msg":"申请预约","already_num":"0","amount":"10","surplus":"10"},{"title":"2018-12-03 星期一 上午 专家门诊","id":"987","date":"1543766400","week":"1","halfday":"1","type":"2","state":"1","money":"14","address":"门诊楼三楼（9点半之前到）","msg":"申请预约","already_num":"0","amount":"10","surplus":"10"},{"title":"2018-12-10 星期一 上午 专家门诊","id":"987","date":"1544371200","week":"1","halfday":"1","type":"2","state":"1","money":"14","address":"门诊楼三楼（9点半之前到）","msg":"申请预约","already_num":"0","amount":"10","surplus":"10"}]
             * rddate : ["2018-11-26","2018-12-03","2018-12-10"]
             * num : {"total":"3","res_num":"3"}
             */

            private Numuser num;
            private List<Rdtimeuser> rdtime;
            private List<String> rddate;

            public Numuser getNum() {
                return num;
            }

            public void setNum(Numuser num) {
                this.num = num;
            }

            public List<Rdtimeuser> getRdtime() {
                return rdtime;
            }

            public void setRdtime(List<Rdtimeuser> rdtime) {
                this.rdtime = rdtime;
            }

            public List<String> getRddate() {
                return rddate;
            }

            public void setRddate(List<String> rddate) {
                this.rddate = rddate;
            }

            public static class Numuser {
                /**
                 * total : 3
                 * res_num : 3
                 */

                private String total;
                private String res_num;

                public String getTotal() {
                    return total;
                }

                public void setTotal(String total) {
                    this.total = total;
                }

                public String getRes_num() {
                    return res_num;
                }

                public void setRes_num(String res_num) {
                    this.res_num = res_num;
                }
            }

            public static class Rdtimeuser {
                /**
                 * title : 2018-11-26 星期一 上午 专家门诊
                 * id : 987
                 * date : 1543161600
                 * week : 1
                 * halfday : 1
                 * type : 2
                 * state : 1
                 * money : 14
                 * address : 门诊楼三楼（9点半之前到）
                 * msg : 申请预约
                 * already_num : 0
                 * amount : 10
                 * surplus : 10
                 */

                private String title;
                private String id;
                private String date;
                private String week;
                private String halfday;
                private String type;
                private String state;
                private String money;
                private String address;
                private String msg;
                private String already_num;
                private String amount;
                private String surplus;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getHalfday() {
                    return halfday;
                }

                public void setHalfday(String halfday) {
                    this.halfday = halfday;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public String getMoney() {
                    return money;
                }

                public void setMoney(String money) {
                    this.money = money;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getMsg() {
                    return msg;
                }

                public void setMsg(String msg) {
                    this.msg = msg;
                }

                public String getAlready_num() {
                    return already_num;
                }

                public void setAlready_num(String already_num) {
                    this.already_num = already_num;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }

                public String getSurplus() {
                    return surplus;
                }

                public void setSurplus(String surplus) {
                    this.surplus = surplus;
                }
            }
        }
    }
}
