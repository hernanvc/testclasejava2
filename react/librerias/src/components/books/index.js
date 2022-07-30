import React , {useState ,useEffect } from 'react'
import {Col,Row,Button , Table ,Modal,Input,DatePicker , Select } from 'antd'
import 'antd/dist/antd.min.css'
import axios from 'axios'

export default function HomeBook(props){
    const [description , setDescription ] = useState('')
    const [title , setTitle ] = useState('')
    const [year , setYear ] = useState('2022-12-12')
    const [categoriId , setCategoriId] = useState()
    const [isModalVisible, setIsModalVisible] = useState(false);

    const [data, setData] = useState([])
    const [categorias, setCategorias] = useState([])

    const onChangePiker = (date, dateString) => {
        console.log(date, dateString);
        setYear(dateString)
    };
    const { Option } = Select;

      

    const createBook =  ()=>{
       
        const headers = {
            'Content-Type': 'application/json',
          
        }
        axios.post('http://localhost:8080/libro/',{
            titulo: title,
            year:year,
            description: description,
            categoria:{
                id : categoriId
            },
            autor:{
                id: 2
            }
        }, {headers : headers}).then(res =>{
            console.log(res);
            getData()
            /*let tem_data = [...data]
            tem_data.push(res.data)
            setData(tem_data)*/
            setTitle('')
            setDescription('')
            setIsModalVisible(false);

        })
    }
    const columns = [
        {
          titulo: 'titulo',
          dataIndex: 'titulo',
          key: 'titulo',
        },
        {
          title: 'year',
          dataIndex: 'year',
          key: 'year',
        },
        {
          title: 'description',
          dataIndex: 'description',
          key: 'description',
        },
        /*{
            title: 'categoria',
            dataIndex: 'categoria',
            key: 'categoria',
            render: categoria => <p>{categoria.description}</p>
          },*/

      ];
    

      const showModal = () => {
        setIsModalVisible(true);
      };
    
      const handleOk = () => {
        setIsModalVisible(false);
      };
    
      const handleCancel = () => {
        setIsModalVisible(false);
      };
    

    useEffect(()=>{
        getCategorias()
        getData()
    },[])

    const getData = ()=>{
        axios.get('http://localhost:8080/libro').then(resp=>{
                setData(resp.data)
        })
    }


    const getCategorias = () =>{
        axios.get('http://localhost:8080/categoria').then(resp=>{
            console.log("categoria",resp);
            setCategorias(resp.data)
        })
    }

    const handleChangeSelect = (value: string) => {
        console.log(`selected ${value}`);
        setCategoriId(value)
      };
    return (
        <>
            <Row>
                <Col span={6}></Col>
                <Col span={6}></Col>
                <Col span={6}></Col>
                <Col span={6}><Button onClick={()=>showModal()}>sadadasa</Button></Col>
            </Row>
            <Row>
                <Col span={24}>
                
                <Table dataSource={data} columns={columns} />;

                </Col>
                <Modal title="Basic Modal" visible={isModalVisible} onOk={createBook} onCancel={handleCancel}>
                            <Input 
                                value={title}
                                placeholder="titutlo" 
                                onChange={(event)=> setTitle(event.target.value) }
                                />
                                <Input 
                                value={description}
                                placeholder="DESCRIPTCIO" 
                                onChange={(event)=> setDescription(event.target.value) }
                                />
                            <DatePicker onChange={onChangePiker} />
                            <Select defaultValue="lucy" style={{ width: 120 }} onChange={handleChangeSelect}>
                                    {
                                        categorias.map(c =>{
                                            return(
                                                <Option value={c.id}>{c.typo}</Option>
                                            )
                                           
                                            
                                        })
                                    }
                                    
                          </Select>
                               
                </Modal>
            </Row>
        </>



    )
}