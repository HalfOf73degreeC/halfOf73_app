package com.halfof73.halfof73.team;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.halfof73.halfof73.R;
import com.halfof73.halfof73.team.ResultFragment;
import com.halfof73.halfof73.team.Team;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        final RecyclerView rvTeam = view.findViewById(R.id.rvTeam);
        final List<Team> teams = getTeams();
        rvTeam.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rvTeam.setAdapter(new TeamAdapter(teams, this.getActivity()));

        return view;
    }

    private class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {//
        List<Team> teams;
        Context context;

        public TeamAdapter(List<Team> teams, Context context) {
            this.context = context;
            this.teams = teams;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {//
            ImageView ivTeam;
            TextView tvName;
            TextView tvPrice;

            public MyViewHolder(View itemView) {
                super(itemView);
                ivTeam = itemView.findViewById(R.id.ivTeam);
                tvName = itemView.findViewById(R.id.tvName);
                tvPrice = itemView.findViewById(R.id.tvPrice);
            }
        }

        @Override
        public int getItemCount() {
            return teams.size();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.item_view_team, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {//
            final Team team = teams.get(position);
            MyViewHolder myViewHolder = (MyViewHolder) holder;//
            myViewHolder.ivTeam.setImageResource(team.getImageId());
            myViewHolder.tvName.setText(team.getName());
            myViewHolder.tvPrice.setText(team.getPrice());
//            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("team", team);
//                    Fragment fragment = new ResultFragment();
//                    fragment.setArguments(bundle);
//                    FragmentManager fragmentManager = getFragmentManager();
//                    if (fragmentManager != null) {
//                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                        fragmentTransaction.replace(R.id.content, fragment);
//                        fragmentTransaction.addToBackStack(null);//強迫儲存此頁資料，讓ResultFragment回來此頁有先前資料
//                        fragmentTransaction.commit();
//                    }
//                }
//            });
        }
    }

       public List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team(R.drawable.clevelandcavaliers, "Cleveland Cavaliers", "$1,325Millions",
                "         克利夫蘭騎士隊（Cleveland Cavaliers），是一支屬於美國的俄亥俄州克利夫蘭（Ohio,Cleveland）的職業籃球隊，是美國男籃職業聯賽（NBA）東部聯盟中部賽區的一部分。\n" +
                        "\n" +
                        "         1970年，克利夫蘭騎士隊正式成立並加入NBA聯盟。2003年，騎士隊選中狀元秀勒布朗·詹姆斯，在詹姆斯的帶領下，騎士隊於2007年首次進入NBA總決賽，但以0-4負於馬刺隊。2011年選秀大會上，騎士隊用狀元簽選中凱里·歐文，同時隊伍進入重建。\n" +
                        "\n" +
                        "         2014年7月12日，詹姆斯宣布回歸騎士隊。同年夏天，騎士隊通過簽約與交易，組建了勒布朗·詹姆斯、凱里·歐文與凱文·樂福的騎士隊三巨頭。2016年6月20日，騎士戰勝勇士奪得2015-16賽季總冠軍。"
        ));
        teams.add(new Team(R.drawable.bostonceltics, "Boston Celitics", "$2,500Millions",
                "         芝加哥公牛隊是一支位於美國伊利諾州芝加哥的職業籃球隊，1966年成立並加入美國男籃職業聯賽（NBA）。現從屬於NBA東部聯盟的中部賽區。\n" +
                        "\n" +
                        "         在度過最初的適應期後，公牛隊漸有起色。1971年起，公牛隊連續四年常規賽取勝50場以上。1974和1975年，公牛隊憑藉頑強的防守兩次殺入分區決賽。1984年，公牛隊在選秀大會上以探花簽選中麥可·喬丹，他帶領公牛隊在1991-1993年和1996-1998年獲得兩次三連冠，成為除波士頓凱爾特人、洛杉磯湖人外奪冠次數最多的NBA球隊。此外，公牛隊在1995-96賽季的82場常規賽中取得72勝。\n" +
                        "\n" +
                        "         進入21世紀，2008年，公牛隊在選秀大會上以狀元簽選中德里克·羅斯，在其帶領下重回爭冠行列，2011年再次殺入東部決賽。2011年和2012年，公牛隊連續兩年獲得NBA常規賽冠軍。\n"
        ));
        teams.add(new Team(R.drawable.atlantahawks, "Atlanta Hawks", "$1,150Millions",
                "         亞特蘭大老鷹隊是一支所屬於美國喬治亞州亞特蘭大的職業籃球隊，成立於1946年，於1949年加入美國男籃職業聯賽（NBA），是NBA東部聯盟東南賽區的一部分。\n" +
                        "\n" +
                        "         1957-58賽季，老鷹隊在鮑勃·佩蒂特率領下，擊敗波士頓凱爾特人隊獲得隊史首座NBA總冠軍。80-90年代，在當家球星多米尼克·威爾金斯和名帥蘭尼·威爾肯斯率領下，成為東部勁旅。2007-08賽季，在經歷了長達8年的重建旅程之後重返季後賽。2014-15賽季，在年度最佳教練邁克·布登霍爾澤的率領下取得隊史最佳的60勝22負戰績並打入東部決賽。2015年1月，老鷹隊單月17戰全勝，成為NBA歷史上單月勝場次數最多的球隊。\n" +
                        "\n" +
                        "         最初命名為「三市黑鷹隊」是借用了酋長「黑鷹「的名字。1951年遷至密爾沃基後，易名為「老鷹隊」。1955年遷至聖路易斯，1968年遷到亞特蘭大市，至今仍一直使用「老鷹隊」這個名字。\n"
        ));
        teams.add(new Team(R.drawable.brooklynnets, "Brooklyn Nets", "$2,300Millions",
                "         布魯克林籃網隊，是一支屬於美國的紐約州紐約市布魯克林區為基地的男子職業籃球隊，屬於美國國家籃球協會（NBA），於1967年組隊並在1976年加入NBA聯盟，是美國男籃職業聯賽東部聯盟大西洋賽區的一部分。\n" +
                        "\n" +
                        "         布魯克林籃網隊原為新澤西籃網隊，球隊在1976年加入NBA聯盟後，未奪得總冠軍，但分別在2001-02和2002-03賽季獲得東部聯盟的頭名。在2004年球隊被轉讓給布魯斯·拉特納，在2012-13賽季後宣布球隊正式遷往紐約市的布魯克林區。而2010年5月份，俄羅斯商人米哈伊爾·普羅霍羅夫以2億美金正式收購籃網。\n"
        ));
        teams.add(new Team(R.drawable.charlottehornets, "Charlotte Hornets", "$1,050Millions",
                "         夏洛特黃蜂隊（Charlotte Hornets）是一支位於美國北卡羅來納州夏洛特的職業籃球隊，其前身夏洛特山貓隊於2004年建隊並加入美國男籃職業聯賽（NBA），是NBA聯盟最年輕的球隊。現從屬於NBA東部聯盟的東南賽區。\n" +
                        "\n" +
                        "         經歷了五個賽季的磨練後，2009-10賽季山貓隊在球隊領袖傑拉德·華萊士和史蒂芬·傑克遜的率領下以東部第七的成績首次殺入季後賽。2010年，山貓隊進入「喬丹時代」，NBA聯盟董事會批准了麥可·喬丹以2.75億美元入主山貓隊的交易。2014年5月21日，山貓隊正式宣布球隊更名為夏洛特黃蜂隊。同時自1988年到2002年的那段黃蜂隊的歷史也正式劃歸到了現夏洛特黃蜂隊名下。\n"
        ));
        teams.add(new Team(R.drawable.dallasmavericks, "Dallas Mavericks", "$1,900Millions",
                "         達拉斯小牛隊是一支位於美國德克薩斯州達拉斯的職業籃球隊，1980年成立並加入美國男籃職業聯賽（NBA）。現從屬於NBA西部聯盟的西南賽區。\n" +
                        "\n" +
                        "         在20世紀80年代，小牛隊被視作一支有前途的球隊。但在90年代初，小牛隊開始下坡路，兩度逼近聯盟歷史最差戰績。90年代中期，小牛隊重新開始恢復元氣。1998年在選秀大會上選中德克·諾維茨基並交易得到史蒂夫·納什後，小牛隊正式成為西部勁旅。2005-06賽季小牛隊首次奪得西部冠軍並進入NBA總決賽。2006-07賽季小牛隊打出隊史最佳的67勝15負戰績，成為常規賽冠軍。2010-11賽季，小牛隊在季後賽中連續擊敗開拓者、湖人、雷霆，再次殺入總決賽，並最終復仇熱火隊，強勢奪下隊史首冠。\n"
        ));
        teams.add(new Team(R.drawable.denvernuggets, "Denver Nuggets", "$1,125Millions",
                "         丹佛掘金隊，是一支屬於美國的科羅拉多州丹佛市的職業籃球隊，屬於美國國家籃球協會（NBA），是美國男籃職業聯賽西部聯盟西北賽區的一部分。\n" +
                        "\n" +

                        "         掘金隊於1967-76賽季開始參加ABA聯賽，1976年起加入NBA。歷史上曾在1975-76賽季打進ABA總決賽，1977-78、1984-85和2008-09賽季三度打進NBA西部決賽，從未奪得過NBA總冠軍。\n"
        ));
        teams.add(new Team(R.drawable.detroitpistons, "Detroit Pistons", "$1,100Millions",
                "         底特律活塞隊，成立於1941年並在1948年加盟NBA，是一支屬於美國的密西根州底特律市的職業籃球隊，是美國男籃職業聯賽（NBA）東部聯盟中部賽區的一部分。\n" +
                        "\n" +
                        "         活塞隊連續1954-55和1955-56兩個賽季殺入NBA總決賽，但先後不敵錫拉丘茲民族隊和費城勇士隊，與冠軍擦肩而過。1957年，活塞搬遷至底特律，球隊更名為底特律活塞。1981年活塞在首輪第二順位選擇了印第安納大學的伊塞亞·托馬斯，在托馬斯的率領下，在1989年的NBA總決賽中4-0橫掃湖人隊奪冠。1990年活塞在總決賽中4-1輕取波特蘭開拓者隊，衛冕成功。2003-04賽季，在主帥拉里·布朗的指揮下，活塞以理察·漢密爾頓與昌西·比盧普斯為核心再次殺入總決賽，並以4-1的總比分擊敗擁有的湖人隊，重回冠軍團隊之列。\n"
        ));
        teams.add(new Team(R.drawable.goldenstatewarriors, "Golden State Warriors", "$3,100Millions",
                "         金州勇士隊（Golden State Warriors），於1946年成立並加盟NBA，是一支屬於美國的加利福尼亞州奧克蘭市（Oakland, California）的職業籃球隊，是美國男籃職業聯賽（NBA）西部聯盟太平洋賽區的一部分。勇士隊主場原來在費城，1962年才搬到加州；由於加州的暱稱是「金州」，故取名「金州勇士」。它是最早加盟NBA的11支球隊之一；在NBA歷史上，曾四次奪過總冠軍，NBA的第一次總冠軍得主就是勇士隊；NBA單場最高分紀錄保持者威爾特·張伯倫就是在勇士隊拿下100分的。在唐·尼爾森成為球隊教練後，勇士隊成為了一支可以為季後賽席位展開爭奪的勁旅，2006-07賽季季後賽第一輪更是淘汰常規賽冠軍小牛隊創造NBA史上第3個「黑八奇蹟」。\n" +
                        "\n" +
                        "         2015年6月17日，NBA總決賽第六場，勇士客場以105-97再勝騎士，總比分4-2奪取總冠軍。這是勇士隊在1974-75賽季以來的第一個冠軍，也是勇士所有球員個人職業生涯的第一個總冠軍。安德烈·伊戈達拉獲得總決賽MVP。\n" +
                        "\n" +
                        "         2015-16賽季，勇士在常規賽中取得73勝9負的成績，打破了公牛在1995-96賽季創下的紀錄，成為NBA歷史單賽季常規賽戰績最好的球隊。\n"
        ));
        teams.add(new Team(R.drawable.houstonrockets, "Houston Rockets", "$2,200Millions",
                "         休斯敦火箭隊，成立於1967年並在1967-68賽季加盟NBA，是一支屬於美國的德克薩斯州休斯敦市的職業籃球隊，是美國男籃職業聯賽（NBA）西部聯盟西南區的一部分。\n" +
                        "\n" +
                        "         火箭隊是一支有高中鋒傳統的球隊，從早期的摩西·馬龍、拉爾夫·桑普森到哈基姆·奧拉朱旺，以及2002年首輪頭名狀元的中國「小巨人」中鋒姚明，再到2013年轉會過來的德懷特·霍華德都是叱吒NBA的傳統中鋒。\n" +
                        "\n" +
                        "         1967年火箭隊建隊時落戶於聖迭戈，經歷了4個平淡的賽季後，於1971年搬到休斯敦。火箭隊在1993-1994和1994-1995兩個賽季連續奪得NBA總冠軍。\n"
        ));
        teams.add(new Team(R.drawable.indianapacers, "Indiana Pacers", "$1,175Millions",
                "         印第安納步行者隊是一支位於美國印第安納州印第安納波利斯的職業籃球隊，從屬於NBA東部聯盟的中部賽區。步行者隊於1967年成立並加入美國籃球協會（ABA），1970、1972、1973年三次獲得ABA總冠軍。1976年美國籃球協會與美國男籃職業聯賽（NBA）合併後，步行者隊成為加入NBA的原ABA聯賽的四支球隊之一。\n" +
                        "\n" +
                        "         步行者隊在70年代未能進入NBA季後賽，80年代開始對陣容做出了一系列調整而有所好轉，90年代在名帥拉里·布朗和拉里·伯德的帶領下四次殺入東部決賽，逐步確立了強隊地位。2000年在雷吉·米勒的帶領下打入總決賽，最終惜敗。\n"
        ));
        teams.add(new Team(R.drawable.losangelesclippers, "Los Angeles Clippers", "$2,150Millions",
                "         洛杉磯快船隊，成立於1970年並加入NBA，是一支屬於美國的加利福尼亞州洛杉磯為基地的NBA職業籃球隊，是美國男籃職業聯賽（NBA）西部聯盟太平洋賽區的一部分。\n" +
                        "\n" +
                        "         快船隊搬遷過多次，1970年初入NBA稱為布法羅勇士隊，1977-78賽季，勇敢者隊搬到聖地亞哥，很快改名為快艇隊。從1976-77賽季開始，快船隊連續16個賽季未能進入季後賽。1981年球隊易主，斯特林成為球隊老闆，在1984年將球隊搬到洛杉磯。但一直擺脫不了魚腩球隊的身份，最好戰績是分區半決賽。\n" +
                        "\n" +
                        "         快船隊在2009年選中的狀元秀布雷克·格里芬，成為球隊未來的基石與希望。2011年休賽期隨著克里斯·保羅的加盟，洛杉磯快船隊正式邁入NBA聯盟強隊行列。\n"
        ));
        teams.add(new Team(R.drawable.losangeleslakers, "Los Angeles Lakers", "$3,300Millions",
                "         洛杉磯湖人隊（Los Angeles Lakers），是一個位於美國加利福尼亞州洛杉磯的籃球俱樂部，1947年成立於明尼阿波利斯，1960年搬遷到了洛杉磯。湖人這個名字來源於明尼阿波利斯的別稱——千湖之地，指在美國東北五大湖工作或者居住的人。\n" +
                        "\n" +
                        "         湖人隊於1948年加入美國職業籃球聯賽（NBA）。球隊的最大特點是總有球星跟他們聯繫在一起。喬治·邁肯是球隊早期主力中鋒，在他的帶領下，湖人很快成為了NBA的豪門球隊。1960年代，埃爾金·貝勒與傑里·韋斯特的到來，使湖人隊在整個60年代從未缺席過季後賽。1976年，湖人隊得到了綽號「天勾」的卡里姆·阿布杜爾-賈巴爾。1979-80賽季，湖人選中新秀埃爾文·詹森，他在該賽季總決賽中頂替受傷的賈巴爾並帶領球隊奪冠。\n" +
                        "\n" +
                        "         1996年夏天，湖人得到「大鯊魚」沙奎爾·奧尼爾，並與夏洛特黃蜂隊交易得到新秀科比·布萊恩特，兩人帶領湖人隊在1999-2002年間取得了三連冠。2007年，保羅·加索爾加入湖人隊，球隊又於2008-2010年三度進入總決賽並2次奪冠。但是傷病開始襲擊湖人，導致球隊不得不進入重建時期。\n" +
                        "\n" +
                        "         截至2016-17賽季結束，湖人隊史共56次進入季後賽、31次獲得西部冠軍、16次獲得總冠軍，僅次于波士頓凱爾特人隊（17次）；最高連勝紀錄為33場（NBA歷史最高）。\n"
        ));
        teams.add(new Team(R.drawable.memphisgrizzlie, "Memphis Grizzlie", "$1,025Millions",
                "         孟菲斯灰熊隊，於1995年加入NBA，是一支位於美國田納西州孟菲斯市的職業籃球隊，是美國男子職業籃球球隊聯賽（NBA）西南賽區的一部分。球隊原名溫哥華灰熊隊（Vancouver Grizzlies），主場設在加拿大的溫哥華市。2001年，灰熊隊遷回美國孟菲斯市，更名為孟菲斯灰熊隊。\n" +
                        "\n" +
                        "         1995年球隊選中新秀布萊恩特·里弗斯。第二年，灰熊隊選中探花新秀、全能前鋒阿布杜爾·拉希姆。這位希望之星，果然實力不凡，迅速確立了核心地位，並和里弗斯一起，組成NBA中名頭響亮的殺手組合。1998年，球隊再把後衛邁克·畢比招入陣中。灰熊隊中雖然不乏明星，可惜戰績卻始終乏善可陳。進入21世紀後，球隊選入西班牙球星保羅·加索爾後，灰熊隊逐漸變得具有競爭力，多次打入季後賽，但從未獲得一場的季後賽勝利，這個悲慘的記錄直到2011年才終止，當時灰熊隊以西部第八的名次與西部第一馬刺隊狹路相逢，在扎克·蘭多夫的帶領下，灰熊不但取下隊史第一場季後賽勝利，而且以4:2的比分淘汰了馬刺隊，上演了NBA歷史上第4次「黑八奇蹟」。\n"
        ));
        teams.add(new Team(R.drawable.miamiheat, "Miami Heat", "$1,700Millions",
                "         邁阿密熱火隊（Miami Heat），於1988年成立並加入NBA，是一支屬於美國佛羅里達州邁阿密市的職業籃球隊，是美國男籃職業聯賽（NBA）東部聯盟東南賽區的一部分。邁阿密熱火隊熱火主場設在邁阿密市中心的美航中心球館。熱火隊與夏洛特黃蜂隊同時成立於1988年NBA，是代表佛羅里達州的兩支NBA球隊之一（另一支為奧蘭多魔術隊）。\n" +
                        "\n" +
                        "         球隊位於四季溫暖宜人的佛羅里達州邁阿密市，所以在眾多候選隊名名單中選擇了「熱」，既顯示出了邁阿密的氣候條件，又希望球隊未來紅紅火火、蒸蒸日上。在最初的7個賽季，儘管熱火擁有格倫·萊斯這樣的超級得分手，但常規賽戰績從未超過50勝，期間只有兩個賽季進入季後賽。1988至2013年的25個賽季里，邁阿密熱火17次闖入季後賽，奪得了10次賽區冠軍，並以4比2擊敗達拉斯小牛隊贏得了2006年NBA總冠軍。\n" +
                        "\n" +
                        "         2003年選秀大會他們在首輪第五順位選擇了來自馬奎特大學的德懷恩·韋德。2004年熱火與洛杉磯湖人交易得到沙奎爾·奧尼爾。2005-06賽季韋德率領熱火首度殺入總決賽，在0-2落後的險境下翻盤達拉斯小牛隊首捧總冠軍。隨著奧尼爾漸漸老去，熱火的戰鬥力出現明顯下滑。\n" +
                        "\n" +
                        "         在2010年夏季交易中，先後得到波什和詹姆斯的加盟，跟隨韋德組成03屆白金一代熱火三巨頭。帶領球隊殺入2010至2011NBA總決賽，但仍以2-4不敵達拉斯小牛隊。2012年總決賽，以4-1戰勝俄克拉荷馬雷霆隊，奪得總冠軍。2013年6月21日經過搶七大戰，以4-3險勝聖安東尼奧馬刺隊，奪得總冠軍。\n"
        ));
        teams.add(new Team(R.drawable.milwaukeebucks, "Milwaukee Bucks", "$1,075Millions",
                "         密爾沃基雄鹿隊，是一支屬於美國的威斯康星州密爾沃基為基地的NBA職業籃球隊，建隊於1968年並同年加入NBA聯盟，是美國男籃職業聯賽（NBA）東部聯盟中部賽區的一部分。\n" +
                        "\n" +
                        "         1970-71賽季，雄鹿隊用三年就登上總冠軍的領獎台，成為加盟NBA後奪冠用時最短的球隊。自2000年開始雄鹿隊實力下降，退出冠軍爭奪行列。2007年，易建聯正式簽約加盟NBA密爾沃基雄鹿隊。憑藉多年的積累，2009-10賽季重返季後賽，再次成為東部一支強隊。\n"
        ));
        teams.add(new Team(R.drawable.minnesotatimberwolves, "Minnesota Timberwolves", "$1,060Millions",
                "         明尼蘇達森林狼隊，1989年進入NBA，是一支位於美國明尼蘇達州明尼阿波利斯市的職業籃球隊，是美國男籃職業聯賽（NBA）西部聯盟西北賽區的一部分。\n" +
                        "\n" +
                        "         1989年，在處子賽季中，森林狼隊僅取得了22勝60負的糟糕成績，此後球隊連續7年常規賽獲勝場次不到30。1995年，森林狼隊在首輪第五順位選中了高中生球員凱文·加內特，1996-97賽季就帶領球隊取得了歷史性的突破，成功殺入季後賽。直到2007年，加內特轉會凱爾特人，森林狼投入重建，隨後在2008年NBA選秀得到了凱文·樂福，在2009年NBA選秀以第五順位選中了西班牙「金童」里基·盧比奧。不過球隊仍連續11年無緣季後賽。\n"
        ));
        teams.add(new Team(R.drawable.neworleanspelicans, "New Orleans Pelicans", "$1,000Millions",
                "         紐奧良鵜鶘隊，是一支屬於美國的路易斯安那州紐奧良為基地的職業男子籃球隊，是美國男籃職業聯賽（NBA）西部聯盟西南賽區的一部分。\n" +
                        "\n" +
                        "         鵜鶘隊原為紐奧良黃蜂隊。2002-03賽季，夏洛特黃蜂隊搬到紐奧良，開啟球隊在紐奧良的歷史。自克里斯·保羅（2005年第一輪第四順位選中）、大衛·韋斯特等球員的成長，球隊成為西部聯盟一支勁旅，但在季後賽中始終沒有突破，隨著其他球隊補強、崛起，也逐漸落於下風。 2013年1月，紐奧良黃蜂隊正式召開新聞發布會，宣布球隊改名為鵜鶘隊。2014-15賽季，球隊以西部聯盟第八再度殺進季後賽。\n"
        ));
        teams.add(new Team(R.drawable.newyorkknicks, "New York Knicks", "$3,600Millions",
                "         紐約尼克斯隊，成立於1946年並加入美洲籃球協會（BAA，NBA的前身），是一支屬於美國的紐約州紐約市為基地的NBA職業籃球隊，是美國男籃職業聯賽（NBA）東部聯盟大西洋賽區的一部分，紐約尼克斯隊是從最初的BAA聯盟開始就沒有搬遷過城市的兩支球隊之一（另外一支是波士頓凱爾特人隊）。\n" +
                        "\n" +
                        "         尼克斯在聯盟的三個不同時代有著輝煌的表現，每個時代都相差二十年左右。在20世紀50年代初，尼克斯三次進入NBA總決賽。20世紀70年代初是球隊的黃金一代，球隊贏得了2個NBA總冠軍。當時在隊中的有威利斯·里德、沃爾特·弗雷澤、戴夫·德布斯切爾、厄爾·門羅和比爾·布拉德利等優秀的球員。接著是在20世紀90年代，尼克斯再次統治了聯盟，因為中鋒派屈克·尤因出現，球隊在1993-94和1998-99賽季均打進總決賽。\n"
        ));
        teams.add(new Team(R.drawable.oklahomacitythunder, "Oklahomacity Thunder", "$1,250Millions",
                "         俄克拉荷馬城雷霆隊（Oklahoma City Thunder）是一支位於美國的俄克拉荷馬城的職業籃球隊，球隊前身西雅圖超音速隊（Seattle SuperSonics）於1966年成立並加入美國男籃職業聯賽（NBA），從屬於NBA西部聯盟的西北賽區。1978-79賽季，超音速隊打出了球隊歷史上第一個50+勝場的賽季，並奪得球隊歷史上第一座NBA總冠軍。2008年，超音速隊遷至俄克拉荷馬城並更名為雷霆隊。2011-12賽季，雷霆隊憑藉凱文·杜蘭特、拉塞爾·威斯布魯克、詹姆斯·哈登三少等人的出色發揮獲得西部冠軍，但總決賽被邁阿密熱火隊4-1擊敗。2012-13賽季，雷霆隊取得常規賽西部第一的戰績。\n"
        ));
        teams.add(new Team(R.drawable.orlandomagic, "Orlando Magic", "$1,225Millions",
                "         奧蘭多魔術隊，成立於1989年並加盟NBA，是一支屬於美國的佛羅里達州奧蘭多為基地的NBA職業籃球隊，是美國男籃職業聯賽（NBA）東部聯盟東南部賽區的一部分，魔術隊在1989-1990賽季加入NBA，僅用了很短的時間就成為冠軍的有力爭奪者。當魔術隊在1992年引進中鋒沙奎爾·奧尼爾後，球隊的競爭實力陡然增強，成為聯盟中最受歡迎的隊伍之一。\n"
        ));
        teams.add(new Team(R.drawable.philadelphia76ers, "Philadelphia 76ers", "$1,180Millions",
                "         費城76人隊，是一支屬於美國的賓夕法尼亞州費城為基地的NBA職業籃球隊，是美國籃球職業聯賽（NBA）東部聯盟大西洋賽區的一部分。\n" +
                        "\n" +
                        "         費城76人隊作為NBA中的一支老牌球隊，在建隊之初既沒有把主場設在費城，也沒有取名為76人隊，而是起了個錫拉丘茲民族隊。1937年組建的錫拉丘茲民族隊隨著NBL（國家籃球聯盟）與ABB（美洲籃球協會）的合併，於1949年加入NBA，76人隊在參加NBA的65年中，曾分別在1954-55、1966-67、1982-83三個賽季奪得全聯盟總冠軍，還有9個半區冠軍。\n"
        ));
        teams.add(new Team(R.drawable.phoenixsuns, "Phoenix Suns", "$1,280Millions",
                "         菲尼克斯太陽隊，是一支屬於美國的亞利桑那州菲尼克斯為基地的男子職業籃球隊，屬於美國國家籃球協會（NBA），於1968年成立並加入NBA聯盟，是美國男籃職業聯賽西部聯盟太平洋賽區的一部分。\n" +
                        "\n" +
                        "         太陽隊在1968年加盟NBA起，一直位列西部勁旅，但從未加冕總冠軍。1969年選秀錯過賈巴爾是太陽隊最大的遺憾。2000年後太陽隊一直堅持小球風格，屢屢打出賞心悅目的比賽，卻始終無緣總決賽，其中最好成績是在1975-76和1992-93兩個賽季闖入總決賽。\n"
        ));
        teams.add(new Team(R.drawable.portlandtrailblazers, "Portland Trail Blazers", "$1,300Millions",
                "         波特蘭開拓者隊，於1970年成立並加盟NBA，是一支屬於美國的俄勒岡州波特蘭市的職業籃球隊，是美國男籃職業聯賽（NBA）西部聯盟西北賽區的一部分。\n" +
                        "\n" +
                        "         開拓者隊在1976-77賽季取得49勝33負的成績，在比爾·沃頓的率領下，第一次殺入季後賽便奪得球隊歷史上唯一的一座冠軍獎盃。此後開拓者隊保持西部強隊的身份，1989-90賽季，開拓者隊再度進入總決賽，決賽不敵「壞孩子軍團」活塞隊。1991-92賽季，開拓者再次殺入總決賽，又負於公牛隊。從1990年至2004年，開拓者隊年年進入季後賽，特別在2000年的西部決賽中，開拓者與湖人隊大戰7場成為經典。\n"
        ));
        teams.add(new Team(R.drawable.sacramentokings, "Sacramento Kings", "$1,375Millions",
                "         薩克拉門托國王隊，於1948年成立並加盟NBA，是一支屬於美國的加利福尼亞州薩克拉門托市的職業籃球隊，是美國男籃職業聯賽（NBA）西部聯盟太平洋賽區的一部分。\n" +
                        "\n" +
                        "         在1950-1951賽季，以羅切斯特皇家隊的身份獲得NBA總冠軍。之後國王隊沒能再有突破。直到進入21世紀，國王隊在主教練里克·阿德爾曼的普林斯頓戰術體系下，以克里斯·韋伯、佩賈·斯托賈科維奇、邁克·畢比、弗拉德·迪瓦茨等球員為核心，搭配以鮑比·傑克遜、希度·特克格魯為主的「板凳匪徒」，成為NBA中比賽最具觀賞性的強隊。\n" +
                        "\n" +
                        "         但在2008年隨著邁克·畢比轉會老鷹隊，標誌著國王隊的黃金一代終告完結。2009年，開始以泰瑞克·埃文斯為核心重建球隊。2013年1月，西雅圖財團宣布臨時協議將收購國王隊，但國王隊在最終被威維克·拉納蒂夫領銜的薩城財團收購。\n"
        ));
        teams.add(new Team(R.drawable.sanantoniospurs_, "Sanantonio Spurs", "$1,550Millions",
                "         聖安東尼奧馬刺隊是一支位於美國德克薩斯州聖安東尼奧的職業籃球隊。其前身達拉斯灌木叢隊於1967年成立並加入美國籃球協會（ABA），1973年搬至聖安東尼奧並改名馬刺隊，1976年加入美國男籃職業聯賽（NBA）。現從屬於NBA西部聯盟的西南賽區。\n" +
                        "\n" +
                        "         馬刺隊是在1976年ABA與NBA合併後保持完整的原ABA聯賽的四支球隊之一，也是原ABA聯賽中唯一一支奪得NBA總冠軍的球隊。1976年以來，馬刺隊共計獲得5次NBA總冠軍，6次西部冠軍，以及21次賽區冠軍。只有四次未能進入季後賽，馬刺隊利用四支樂透簽相繼選中了埃爾文·羅伯特森（1984年第7順位）、大衛·羅賓遜（1987年狀元）、肖恩·埃利奧特（1989年第3順位）和蒂姆·鄧肯（1997年狀元）。\n" +
                        "\n" +
                        "         80年代，在「冰人」喬治·格文的率領下，馬刺於1982、1983年連續闖入西部決賽。90年代，兩位狀元秀「海軍上將」大衛·羅賓遜和「大基本功」蒂姆·鄧肯的「雙塔戰術」在1999年為球隊帶來了首個NBA總冠軍。進入21世紀，隨著托尼·帕克和馬努·吉諾比利等人相繼加入，馬刺成為聯盟中最具統治力的球隊之一。2003年，馬刺4比2戰勝總決賽對手網隊奪冠。2005年，馬刺在總決賽中與同樣以防守團隊體系著稱的活塞隊鏖戰七場奪冠。2007年，馬刺在總決賽橫掃騎士隊，奪取了九年中第四座總冠軍獎盃，正式標誌「馬刺王朝」的誕生。2014年，馬刺在總決賽中以4比1輕取熱火隊，第五次奪得NBA總冠軍，成為除波士頓凱爾特人、洛杉磯湖人、芝加哥公牛外奪冠次數最多的NBA球隊。\n"
        ));
        teams.add(new Team(R.drawable.torontoraptors, "Toronto Raptors", "$1,400Millions",
                "         多倫多猛龍隊，是NBA最年輕的球隊之一，於1995年成立並在1995-1996賽季加盟NBA，是一支屬於加拿大安大略省的省會多倫多的職業籃球隊，是美國男籃職業聯賽（NBA）東部聯盟大西洋賽區的一部分。\n" +
                        "\n" +
                        "         猛龍隊位於加拿大的多倫多，是NBA唯一隊址在美國之外的球隊。猛龍隊的歷史很短，但加盟NBA幾年後很快就成為東部有競爭實力的球隊之一。1995-1996賽季，猛龍隊第一次征戰NBA，新秀達蒙·斯塔德邁爾是他們第一個賽季的領軍人物。2003年起克里斯·波什成為球隊核心。2010年隨著波什轉會至邁阿密熱火隊，猛龍隊開始進入無領袖時期。2013年在短暫的魯迪·蓋伊時代結束後，2013-2014賽季凱爾·洛瑞和德瑪爾·德羅贊組成後場雙槍。\n"
        ));
        teams.add(new Team(R.drawable.utahjazz, "Utah Jazz", "$1,200Millions",
                "         猶他爵士隊，於1974年成立並加盟NBA，是一支屬於美國的猶他州鹽湖城的職業籃球隊，是美國男籃職業聯賽（NBA）西部聯盟西北賽區的一部分。\n" +
                        "\n" +
                        "         爵士隊於1974年在紐奧良成立，1979年搬遷至鹽湖城。經歷了最初幾年的掙扎後，從20世紀80年代開始，爵士隊成為季後賽的常客，從1983年到2002年，年年常規賽的勝率超過50%，連續19年打入季後賽。1997年和1998年，爵士隊兩次打入總決賽，但兩次都敗給芝加哥公牛隊，2009-2010賽季，爵士隊以西部第五的成績殺入季後賽。\n"
        ));
        teams.add(new Team(R.drawable.washingtonwizards, "Washington Wizards", "$1,350Millions",
                "         華盛頓奇才隊，成立於1961年並加盟NBA，是一支屬於美國的哥倫比亞特區華盛頓為基地的NBA職業籃球隊，是美國男籃職業聯賽（NBA）東部聯盟東南部賽區的一部分。\n" +
                        "\n" +
                        "         奇才隊又稱華盛頓巫師隊，是NBA中名字變化最多的球隊，前身是巴爾的摩子彈隊。從60年代開始，球隊就是東部的強隊之一，連續打入季後賽，並於1977-78賽季奪得球隊歷史上第一座總冠軍，不過90年代奇才隊大部分時間在扮演失敗者的角色，整個90年代只於1996-1997賽季進過季後賽。隨著吉爾伯特·阿里納斯在2004-05賽季的強勢崛起，奇才隊重新殺入季後賽。但從2008年至2011年，奇才隊連續三年與季後賽無緣，直到2013-14賽季，在約翰·沃爾等球員的帶領下，重返季後賽。\n"
        ));
        return teams;
    }


}

