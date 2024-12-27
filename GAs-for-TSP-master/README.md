# GAs-for-TSP
2. thuật toán di truyền
bài toán dành cho GAs là tìm kiếm trên không gian các giả thuyết ứng cử để xác định giả thuyết tốt nhất. Trong GAs " giả thuyết tốt nhất" đc định nghĩa như là 1 giả thuyết tối ưu hóa 1 đại lượng số được định nghĩa trước cho bài toán sắp tới, được gọi là độ thích nghi của giả thuyết. Ví dụ, nếu tác vụ học hỏi là bài taosn xấp xỉ 1 hàm chưa biết trong tập mẫu huấn luyện gồm dữ liệu đầu vào và dữ liệu đầu ra,thì độ thích nghi có thể được định nghĩa như là độ chính xác của giả thuyết trên dữ liệu huấn luyện này. Nếu tác vụ là học chiến lược chơi cơ,độ thích nghi có thể là số ván thắng của chiến lược này khi đấu vs các chiến lược khác trong quần thể hiện tại
mặc dù các gt di truyền được thực hiện thay đổi theo bài taosn cụ thể, nhưng chúng chia sẻ chung cấu trúc tiêu biểu sau: thuật giải hoạt động bằng cách cập nhật liên tục giả thuyết đgl quần thể. Ở mỗi lần lặp, tất cả các cá thể trong quần thể đc ước lượng tương ứng vs hàm thích nghi. rồi quần thể ms được tạo ra bằng cách lựa chọn có xác suất các cá thể thích nghi rốt nhất từ quần thể hiện tại. Mỗi số trong những cá thể đc chọn đc đưa nguyên vẹn vào quần thể kế tiếp. Những cá thể khác đc dùng làm cơ sở để tạo ra các cá thể con bằng cách ấp dụng các tac động di truyền : lai ghép và đột biến
GA(Fitness,Fitness_threshold,p,r,m){
//Fitness : hàm gán thang điểm ước lượng cho 1 giả thuyết
//Fitness_threshold: ngưỡng xác định tiêu chuẩn dừng giải thuật tìm kiếm
//p: số cá thể trong quần thể giả thuyết
//r: phân số cá thể trong quần thể đc áp dụng toán tử lai ghép ở mỗi bước
//m: tỉ lệ cá thể bị đột biến
Khởi tạo quần thể: P <- Tạo ngẫu nhiêu p cá thể giả thuyết
Ước lượng: Ứng vs mỗi h trong P, tính Fitness(h)
while[max Fitness(h)]<Fitness_threshold do
	tạo thế hệ ms, Ps
	1. Chọn cá thể: chọn theo xác suất (1-r)p cá thể trong quần thể P thêm vào Ps. xác suất Pr(hi) của giả thuyết hi thuộc P đc tính bởi công thức: pr(hi)= Fitness(hi)/(xích ma j=1-p Fitness(hj) )
	2. lai ghép:chọn lọc theo xác suất r.q/2 cặp giả thuyết từ quần thể P, theo Pr(hi) đã tính ở bc trên. Ứng vs mỗi cặp <h1,h2> tạo ra 2 con bằng cách áp dụng toán tử lai ghép. Thêm tất cả các con vào ps
	3. đột biến: chọn m% cá thể của Ps vs xác suất cho mỗi cá thể là như nhau, ứng vs mỗi cá thể biến đổi 1 bit đc chọn ngẫu nhiên trong cách thể hiện của nó
	4. cập nhật: p <- Ps
	5. ước lượng: ứng vs mỗi h trong P, tính Fitness(h)
Trả về giả thuyết trong P có độ thích nghi cao nhất
3. các toán tử di truyền
3.1 Lai ghép:
Phép lai là quá trình hình thành NST ms trên cơ sở NST cha mẹ, bằng cách 1 hay nhiều đoạn gen của 2 ( hay nhiều ) NST cha mẹ khác nhau
các cặp cha mẹ đc lựa chọn ngẫu nhiên và xác suất xảy ra lai ghép vs mỗi cặp đc quy định từ trc
3.2 đột biến
đột biến là tình trạng NST con k có 1 ( họă 1 số ) tính trạng có trong mã di truyền của cha mẹ
các cặp cha mẹ đc lựa chọn ngâu nhiên và xác suất xảy ra đột biến vs mỗi cặp đc quy định từ trc, thường là rất nhỏ
4. đấu tranh sinh tồn
chọn những NST từ quần thể kết quả theo 1 quy tắc nào đó thay thế cho cha mẹ để sinh ra thế hệ ms

Phần II. cài đặt giải thuật
1.1 mã hóa bài toán
1.1.1 mã hóa đồ thị
đồ thị đc mã hóa bằng danh sách mảng các điểm và tọa độ tương ứng của chúng
1.1.2 mã hóa chu trình ( cá thể - gen )
chu trình đc mã hóa bằng mảng có thứ tự các số hiệu của đỉnh.
ngoài ra mỗi chu trình cần phải có thêm thông số về chi phí của toàn bộ chu trình đó. chi phí này đc tính bằng tổng độ dài tất cả các cạnh tạo nên chu trình đó
mỗi chu trình là 1 lời giải, trong đó giải thuật di truyền coi đó như 1 cá thể. việc tiến hóa về sau ta sẽ dựa trên tập chu trình khởi tạo ban đầu và tìm ra kết quả tốt nhất sau 1 số thế hệ
1.2 khởi tạo quần thể
quần thể ban đầu đc khởi tạo bằng cách sinh ngẫu nhiên các chu trình, số lượng chu trình khởi tạo là 1 nửa số kích thước cá thể tối đa. việc sinh ngẫu nhiên sử dụng hàm đột biến. số kích thước cá thể tối đa có thể tùy biến theo số đỉnh của đồ thị cần giải.
1.3 lai ghép
1.4 đột biến
1.5 chọn lọc tự nhiên
kích thước quần thể là cố định qua các thế hệ. ở mỗi thế hệ ta lại có các cá thể ms sinh bằng lai ghép và đột biến do đó cần phải cso sự chọn lọc để đảm bảo tính cân bằng của quần thể cũng chính là tránh các lỗi phát sinh về bộ nhớ khi kích thước quần thể quá lớn
số cá thể ở 1 thế hệ = kích thước mặc định + số cá thể mới sinh
cách thức chọn lọc cá thể đc đánh giá dựa trên chi phí của mỗi chu trình. cá thể đc chọn làm lời giải cuối cùng là cá thể có chi phí nhỏ nhất trong quần thể sau 1 số thế hệ tiến hóa
ban đầu toàn bộ quần thể sẽ đc sắp xếp tăng dần về chi phí và chỉ giữ lại những cá thể thích nghi nhất ( có chi phí nhỏ nhất ). tuy nhiên cách làm này có hạn chế vs những bộ dữ liệu lớn. Khi số thế hện đạt đến 1 mức nhất định, việc tìm ra chu trình nhỏ hơn ngày càng khó khăn cho nên tập cá thể trong quần thể ganf như k biến đổi, điều này làm giảm sự đa dạng nguồn gen cho tiến hóa ở các thế hện sau
1.6 tiến hóa
vs quần thể khởi tạo ban đầu, chúng đc tiến hóa 1 cách ngẫu nhiên và thích nghi vs điều kiện chọn lọc, các cá thể kém thích nghi sẽ bị loại thải  và các cá thể tốt nhất đc chọn làm lời giải
việc tiến hóa diễn ra qua 1 số thế hệ, ở mỗi thế hện ta thực hiện lai ghép và đột biến ngẫu nhiên trên quần thể
	lai ghép: ngẫu nhiên trong 50% số cá thể đứng đầu tiên của quần thể ( lựa chọn cha mẹ ngẫu nhiên )
	đột biến cho toàn bộ quần thể 100% ( tuy điều này có vẻ trái tự nhiên nhưng việc tìm ra nguồn gen ms cần ưu tiên hơn hết )
sau 1 số thế hện định trước ( 10000-10000000 ) chương trình sẽ dừng và xuất ra kết quả


2. code
yêu cầu bài toán: xuất ra lộ trình đi qua tất cả các thành phố vs chi phí min. Mã hóa theo giải thuật di truyền: 
	Gen: tương ứng là mỗi thành phố trong lộ trình
	Chromosome (Nhiễm sắc thể): mang thông tin di truyền → tương ứng là 1 lộ trình chứa tất cả các thành phố cần phải đi qua, mỗi hoán vị các thành phố là 1 lộ trình
	Population : quần thể chứa nhiều NST → tương ứng là chứa tất cả các hoán vị các thành phố
→ Population chứa n Chromosome, Chromosome lại chứa m Gen
==> Cần có 3 class chính ứng vs Population,Chromosome và Gen : Population, Individual và City.
Thuật toán di truyền dựa trên 3 hoạt động chính : lai ghép, đột biến và chọn lọc
Flow: Chọn cha mẹ → crossover → mutation → child → select best child → new Generation
+ crossover: có nhiều pp để lai ghép ( uniform order crossover, one point crossover,two point crossover,…)
+ mutation : 
## Thành Viên
Nhóm gồm 4 thành viên: Tiến, Hùng, Thái, Hiếu. Trong đó, Hiếu cài đặt thuật toán crossover.

References:
- https://github.com/hoanghungbk/GAs-for-TSP
