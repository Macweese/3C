/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package challenge.leetcode.medium.reverseWordsInAString;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 10:52 Wed 15 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("151. Reverse Words in a String")
class ReverseWordsInAStringTest
{
	private static final Map<String, String> MAP = new HashMap<>();

	static
	{
		MAP.put("the sky is blue","blue is sky the");
		MAP.put("  hello world  ","world hello");
		MAP.put("a good   example","example good a");
		MAP.put("  confusing  ","confusing");
		MAP.put("renew  upward ","upward renew");
		MAP.put(" ride kindest ","kindest ride");
		MAP.put("shriekingly    possible   ","possible shriekingly");
		MAP.put("pronouncement  slim  outlandishness    ","outlandishness slim pronouncement");
		MAP.put("dialectically voluptuously dictating  ","dictating voluptuously dialectically");
		MAP.put("joltingly   became  praising  unenviously  ","unenviously praising became joltingly");
		MAP.put("     still  widewhere  modally    embroilment    united  ","united embroilment modally widewhere still");
		MAP.put("modified  pushes   reinforced    orator  premier   lyricist    ","lyricist premier orator reinforced pushes modified");
		MAP.put("geneticist    degeneration  lavishly   hard  exchanges narcotically   command","command narcotically exchanges hard lavishly degeneration geneticist");
		MAP.put("fairer    knitwise ignorance   resist lived    nonentity revocation hilariousness  ","hilariousness revocation nonentity lived resist ignorance knitwise fairer");
		MAP.put("full   mindlessness    drove   suppressor   factuality    housed    tracking    sociologist ","sociologist tracking housed factuality suppressor drove mindlessness full");
		MAP.put("              seasonal  luminescence   fraternization wrong strengthened  nobility  blaming whizzingly ","whizzingly blaming nobility strengthened wrong fraternization luminescence seasonal");
		MAP.put("short wasted  racially   talkatively  declared narrowly endures   waspishly    believed  bend  ","bend believed waspishly endures narrowly declared talkatively racially wasted short");
		MAP.put("noisily    double  attended    inspector    consternation   enter  activist   louder    flightiness   ","flightiness louder activist enter consternation inspector attended double noisily");
		MAP.put(" science   reemergence fearfully    screams  planted variety  philanthropically  onwards  secondary ","secondary onwards philanthropically variety planted screams fearfully reemergence science");
		MAP.put("cohesiveness   volubly  investigate  hidden   instinct   alters    incitingly    adapts    crystallization   ","crystallization adapts incitingly alters instinct hidden investigate volubly cohesiveness");
		MAP.put("teaches    nonoccurrence  stardom  pop   nearby reverse    selectivity    contribution obediently  freelancer ","freelancer obediently contribution selectivity reverse nearby pop stardom nonoccurrence teaches");
		MAP.put("  odor    chlorination    awaited   consolation    leanly    oversoon contract    arrogantly subservience   pluckily","pluckily subservience arrogantly contract oversoon leanly consolation awaited chlorination odor");
		MAP.put("visible  lacked   factorization  resigns  stayed    wearisomely   compared    sanction    plant publicity  assuring  ","assuring publicity plant sanction compared wearisomely stayed resigns factorization lacked visible");
		MAP.put("percolation    draftsmanship   cooperating    paint  concrete fogginess   unswervingly    marketed  stocked  juror youthwards    ","youthwards juror stocked marketed unswervingly fogginess concrete paint cooperating draftsmanship percolation");
		MAP.put("effectuality   educator marches    details   deflection  smoothest    deflection    financial  pinning    effective spiritual  quoted    ","quoted spiritual effective pinning financial deflection smoothest deflection details marches educator effectuality");
		MAP.put("exotic   exception   assertiveness melted   pouring   waste purpose   outstanding   exporter advisably  station   waifishly   kissing saw  stateliness    ","stateliness saw kissing waifishly station advisably exporter outstanding purpose waste pouring melted assertiveness exception exotic");
		MAP.put("eagerest  seemingly   heading    shallowness   coherent metaphysically   numerably biologist    colonial   grouchiness  respondent  concealment   dirty    ","dirty concealment respondent grouchiness colonial biologist numerably metaphysically coherent shallowness heading seemingly eagerest");
		MAP.put("luxuriousness    recording   display racing   trickster   adhere sweet dereliction    detachedness steers  faculties    protect  unjustly  neatness demolition","demolition neatness unjustly protect faculties steers detachedness dereliction sweet adhere trickster racing display recording luxuriousness");
		MAP.put("  whimsically morbidity floating    disinfectant  incompatibility  vulnerable  initially taxation    persisted  attainment   supervisor   community resurrection   ","resurrection community supervisor attainment persisted taxation initially vulnerable incompatibility disinfectant floating morbidity whimsically");
		MAP.put("unamusedly carbonation   responsible    files   convert playability   plainly  recontamination  bachelor signs    ticklishness   disbarment  unnaturally  evolution   together ","together evolution unnaturally disbarment ticklishness signs bachelor recontamination plainly playability convert files responsible carbonation unamusedly");
		MAP.put("merge    objects hungrily   handier  unsociability poured   unyieldingly    transition    tepidly   introvertedly experimental arraignment  obviously   northeasterly   builder","builder northeasterly obviously arraignment experimental introvertedly tepidly transition unyieldingly poured unsociability handier hungrily objects merge");
		MAP.put("commercial uniaxially  endearingly decontamination   heard  convention   walk  instruction shop    sorted controls  retires    discriminate swifter    traitorously    restrictive","restrictive traitorously swifter discriminate retires controls sorted shop instruction walk convention heard decontamination endearingly uniaxially commercial");
		MAP.put("  opportunist    drifting   effectively free intimately misdemeanor  stature ghostliness  downhill    balancing decussately    comprehensiveness   irradiation  reallocation    tepidly    ","tepidly reallocation irradiation comprehensiveness decussately balancing downhill ghostliness stature misdemeanor intimately free effectively drifting opportunist");
		MAP.put("save   sticked   klutziness  cancel    durability slides    mistreatment  militarily  inequality   irresponsiveness ruler   stay    oblongly   bitter   destructivity  seemliness conveyance   unfair  ","unfair conveyance seemliness destructivity bitter oblongly stay ruler irresponsiveness inequality militarily mistreatment slides durability cancel klutziness sticked save");
		MAP.put(" struggled   wild  travels decides perspicuously wakes    gamely  borrows  hyphenation    nonvertically    conspirator   explores    used    fighter  ineptness   sociability   coalition   effeminately  younger   ","younger effeminately coalition sociability ineptness fighter used explores conspirator nonvertically hyphenation borrows gamely wakes perspicuously decides travels wild struggled");
		MAP.put("springing   broadcaster    cut  arrogantly  tolerability sweatiness  prowess    typical    verdantly  expanding slashingly   dress  expressively   changelessness   object  appointment    roll    spotted   delayingly  ","delayingly spotted roll appointment object changelessness expressively dress slashingly expanding verdantly typical prowess sweatiness tolerability arrogantly cut broadcaster springing");
		MAP.put("  levels  aimed    crudeness   confront materially popped  scream marks   biblically    needs    greatest   jauntily    mounted thereby  understood flautist    presumption  revised    preserving decorate  tartness  recklessly","recklessly tartness decorate preserving revised presumption flautist understood thereby mounted jauntily greatest needs biblically marks scream popped materially confront crudeness aimed levels");
		MAP.put(" offensively    moderator   inner   embarrassment mental  inactivation    redemption   toxicologist    blows    spookiness   hereinafter   continues  displayed    erectly  pity  timelessness unbendingly beware   cleaning    eternally","eternally cleaning beware unbendingly timelessness pity erectly displayed continues hereinafter spookiness blows toxicologist redemption inactivation mental embarrassment inner moderator offensively");
		MAP.put("pickaback    condensation   pitiably   staunchness   overvaluation tearfully   outline  rawer    expectantly    homewards  punishingly  showmanship    exposed    directs notified   lawlessness   truncation    genuinely   storing  adopted    ","adopted storing genuinely truncation lawlessness notified directs exposed showmanship punishingly homewards expectantly rawer outline tearfully overvaluation staunchness pitiably condensation pickaback");
		MAP.put(" wants   vandalism  released concreteness   philanthropist uneasiest   surveyor    strategically    horrifyingly  thrust contained approach   quintessentially    festivity kissably push  resembled    graciously honorably  hangs   wordily ","wordily hangs honorably graciously resembled push kissably festivity quintessentially approach contained thrust horrifyingly strategically surveyor uneasiest philanthropist concreteness released vandalism wants");
		MAP.put("timed results   quits  withdrew    crookedness rows    understatement   prolongation mercifully idly   justifiedly standard   derangement  respiration reconcile    vainness    marking    thrill    inquisitively    newly   unimportance    landing","landing unimportance newly inquisitively thrill marking vainness reconcile respiration derangement standard justifiedly idly mercifully prolongation understatement rows crookedness withdrew quits results timed");
		MAP.put("conspirator biting    huger    sedition  repeated    away  declared   jumblingly paternally    stuffiness   normality   lineage   usefulness    formation    descriptiveness  highhandedness namelessness  denouement  limited   barely    aboriginally    ","aboriginally barely limited denouement namelessness highhandedness descriptiveness formation usefulness lineage normality stuffiness paternally jumblingly declared away repeated sedition huger biting conspirator");
		MAP.put("amalgamation   descendant    wofully  hydration  mixed   civility    getting  wimpishly avoids humanitarian  teasingly    formidability drowns  pollutant  soapiness  vagally abeam    apportionment   erectly    proneness  proved    concerned    sneer huffiness","huffiness sneer concerned proved proneness erectly apportionment abeam vagally soapiness pollutant drowns formidability teasingly humanitarian avoids wimpishly getting civility mixed hydration wofully descendant amalgamation");
		MAP.put("bohemian signalling isolated    cantankerously    foolishly   philosophically    note    disorganization investigator    metallization    sense  sentiments formality committing    featured  unreasonableness    drain    chase blessedly   weather    colonization","colonization weather blessedly chase drain unreasonableness featured committing formality sentiments sense metallization investigator disorganization note philosophically foolishly cantankerously isolated signalling bohemian");
		MAP.put("   migration   timelessly   times    scratched   running    uniform    winningly tighten  own  visitation climbs   submit due    eviction  start   karmically  uxoriously   obeyingly guided    confessing   responded oneness    bitingly  devoutness    granted criticise   tutorship warranty    ","warranty tutorship criticise granted devoutness bitingly oneness responded confessing guided obeyingly uxoriously karmically start eviction due submit climbs visitation own tighten winningly uniform running scratched times timelessly migration");
		MAP.put("   evaluating  underwent   push mortally    simplemindedness    feudally skillfully    materialization  forgiven    claims  uniqueness sure   bleaker   lists  propellant shipward mood    ago    softening abomination    tear warily   domestic  helpfully   same    strains    annuity  climbed ","climbed annuity strains same helpfully domestic warily tear abomination softening ago mood shipward propellant lists bleaker sure uniqueness claims forgiven materialization skillfully feudally simplemindedness mortally push underwent evaluating");
		MAP.put(" receiving  fetching  interestingly    ichily    modern    third  warmly   portion  divorces    unconcernedly    persuading   issues   cooled   hieroglyphically   perversely  scientific   aptitude unhappier    enticingly  calm  erectly    risking   yellowest maximise  supervising    radiance   ","radiance supervising maximise yellowest risking erectly calm enticingly unhappier aptitude scientific perversely hieroglyphically cooled issues persuading unconcernedly divorces portion warmly third modern ichily interestingly fetching receiving");
		MAP.put("worries  done   unwisely itchiness    sound    youngness   illustriousness  pursued falser real    chatted   zootomically    reversing consultant   acquiring westwards   explains   segmentation   placidity  fighter   versatilely  enclosed  optatively misinterpretation  obstinacy   hoarsely","hoarsely obstinacy misinterpretation optatively enclosed versatilely fighter placidity segmentation explains westwards acquiring consultant reversing zootomically chatted real falser pursued illustriousness youngness sound itchiness unwisely done worries");
		MAP.put("       former    adding   deliberate   tightest   ion  whole definition whistly    packing  viperishly retentively   attraction    posterity   wrily   departing    reasonable   similarly  trickily  eruption  inheritor  virescently    convey  progressed commutation exceptionally    specific    whole","whole specific exceptionally commutation progressed convey virescently inheritor eruption trickily similarly reasonable departing wrily posterity attraction retentively viperishly packing whistly definition whole ion tightest deliberate adding former");
		MAP.put("shamelessness  abasement   guidance electrical    recruit avoid   greyest  popularly   pettiness    matches    rigidity    dominates contemporary   flows    cool  government classified    slipperiness   terrible    intensely uppermore   incorrigibly   discontinuance    collect   infection bottom","bottom infection collect discontinuance incorrigibly uppermore intensely terrible slipperiness classified government cool flows contemporary dominates rigidity matches pettiness popularly greyest avoid recruit electrical guidance abasement shamelessness");
		MAP.put("historically handcraftsmanship    devise   respected   alteration   seriously  public    uninvitedly    brawniness  interacted    unimportance   outside   entrapment    multiplication  courageously   jubilation times lightfootedly agreement narrower  elaborate accelerated   lengthier eagerer sets","sets eagerer lengthier accelerated elaborate narrower agreement lightfootedly times jubilation courageously multiplication entrapment outside unimportance interacted brawniness uninvitedly public seriously alteration respected devise handcraftsmanship historically");
		MAP.put("accounts   insufficient disrupts   admiring  quicker slightest   constitution  elevation extra brotherhood    surefootedness incitement  unbeware  rhythmically    newly render  anointment   confidentiality  extracting haughtily  solving   handing  wrong    limitation smallness  hypnotherapist  soon ","soon hypnotherapist smallness limitation wrong handing solving haughtily extracting confidentiality anointment render newly rhythmically unbeware incitement surefootedness brotherhood extra elevation constitution slightest quicker admiring disrupts insufficient accounts");
		MAP.put(" frying  sacrifice  invented    modulation   lightly smokelessly    reports   fluidity profits utterance   unhappiest   intending cracking  resigned reiteration foster  segment student freshest    alternatively   foresightedness   precursor    evaluated    zoonotically  soapiness    advisement    aviation   favoredly  ","favoredly aviation advisement soapiness zoonotically evaluated precursor foresightedness alternatively freshest student segment foster reiteration resigned cracking intending unhappiest utterance profits fluidity reports smokelessly lightly modulation invented sacrifice frying");
		MAP.put("cheerily mockingly   folklorist unbendingly liquidly maliciousness   attach dissolution    invalidator    consuming    separated   wittiness    surrender   generally  sign grimmer    windily advances    impishly hardiness dazzlingly   conqueror  regretting desecration    consolation    underutilization  illogically    ","illogically underutilization consolation desecration regretting conqueror dazzlingly hardiness impishly advances windily grimmer sign generally surrender wittiness separated consuming invalidator dissolution attach maliciousness liquidly unbendingly folklorist mockingly cheerily");
		MAP.put("insecurely    instructorship    beating arrogance    resident   angered    angularity  dimply    saved  dialectician flashingly   whiter   consignor   wickedness   malignantly  excluded misplacement inconsolably  giftedness    firsthand    slowest  casual flatteries  fervently  attempt participant  progressed  vast   marine  ","marine vast progressed participant attempt fervently flatteries casual slowest firsthand giftedness inconsolably misplacement excluded malignantly wickedness consignor whiter flashingly dialectician saved dimply angularity angered resident arrogance beating instructorship insecurely");
		MAP.put(" insisted proctor   beautification    simultaneously   manages   governs ambiance  perfectionist   unfearingly    neurotically disrupted  accused    illustrate firmest   amendment    frenzy repeated  sufficing  unshakably   favorably   gaudily    ineffectualness   ancient  misapplication   proper   adherence excusing    interrogation    ","interrogation excusing adherence proper misapplication ancient ineffectualness gaudily favorably unshakably sufficing repeated frenzy amendment firmest illustrate accused disrupted neurotically unfearingly perfectionist ambiance governs manages simultaneously beautification proctor insisted");
		MAP.put("   by   reflecting    nutritiously  yestereven    isolates   recruitment  shout   glossiness travelling elected  divides    fuzziness heated  obnoxiously  controlled persuade cheered   subcategory   entering  price    willingly   elliptically  remaining  passionately   sustaining    conceded    elementally contortionist recalls    cleaner  ","cleaner recalls contortionist elementally conceded sustaining passionately remaining elliptically willingly price entering subcategory cheered persuade controlled obnoxiously heated fuzziness divides elected travelling glossiness shout recruitment isolates yestereven nutritiously reflecting by");
		MAP.put("   healthily   seasonal appropriate  timelessness compatibility assent    humiliation   hypocritically   occasional reconstruction indignantly unyieldingly   stealthily underwent    predict   unresponsively   predecessor    ripely   react    longly    mightiness calms clears shagginess plausibility    howso descend    toothlessly  ruined   humanely  ","humanely ruined toothlessly descend howso plausibility shagginess clears calms mightiness longly react ripely predecessor unresponsively predict underwent stealthily unyieldingly indignantly reconstruction occasional hypocritically humiliation assent compatibility timelessness appropriate seasonal healthily");
	}

	@Test
	void reverseWords()
	{
		for (Map.Entry<String, String> entry : MAP.entrySet())
		{
			final String input = entry.getKey();
			final String expected = entry.getValue();
			final String actual = ReverseWordsInAString.reverseWords(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", input,
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}