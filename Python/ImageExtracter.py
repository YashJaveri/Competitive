import cv2
import os
import img2pdf

# Function to extract frames 
def frame_capture(name, count, path): 
    vid_obj = cv2.VideoCapture(path)     
    success = 1
     
    total_frames = vid_obj.get(cv2.CAP_PROP_FRAME_COUNT)
    quest_frame_number = 30
    ans_frame_number = total_frames - 15
    vid_obj.set(cv2.CAP_PROP_POS_FRAMES, quest_frame_number-1)
    success, frame = vid_obj.read()
    cv2.imwrite(os.path.join( "/Users/yashjaveri/Documents/CE/Python/"  + name, "aq_" + name + "_" + count + "_quest" + ".jpg"), frame)
    vid_obj.set(cv2.CAP_PROP_POS_FRAMES, ans_frame_number-1)
    success, frame = vid_obj.read()
    cv2.imwrite(os.path.join("/Users/yashjaveri/Documents/CE/Python/" + name, name + "_" + count + "_ans" + ".jpg"), frame)


  
if __name__ == '__main__':

    arr_path = ["/Users/yashjaveri/Documents/Other/GRE/GRE Mogoosh/SC/Medium", "/Users/yashjaveri/Documents/Other/GRE/GRE Mogoosh/SC/Hard", "/Users/yashjaveri/Documents/Other/GRE/GRE Mogoosh/TC/Medium", "/Users/yashjaveri/Documents/Other/GRE/GRE Mogoosh/TC/Hard", "/Users/yashjaveri/Documents/Other/GRE/GRE Mogoosh/Quant (Math)/Quant/Hard", "/Users/yashjaveri/Documents/Other/GRE/GRE Mogoosh/Quant (Math)/Quant/Very Hard"]
    name_arr = ["Verbal_SC_med",  "Verbal_SC_hard", "Verbal_TC_med", "Verbal_TC_hard", "Quant_Hard",  "Quant_VeryHard"]    
    m_count = 0
    for a in arr_path:
        path = a
        name = name_arr[m_count]
        m_count += 1
        save_path = "/Users/yashjaveri/Documents/CE/Python/" + name
        count = 0
        os.mkdir(save_path)        
        arr = [(path + "/" + i) for i in os.listdir(path) if i.endswith(".webm")]
        #arr.sort(key=lambda a: int(a[74:-5])) for quants very hard
        #arr.sort(key=lambda a: int(a[79:-5])) for quants hard
        arr.sort()        
        for file in arr:            
            #print("arr" + str(file))
            count += 1
            final_path=os.path.join(path, file)
            frame_capture(name, str(count), final_path)

        with open(name + ".pdf", "wb") as f:
            a = [(save_path+"/"+i) for i in sorted(os.listdir(save_path + "/"), reverse=True) if i.endswith(".jpg")]
            a.sort()
            #print(str(a))
            f.write(img2pdf.convert(a))                                                                